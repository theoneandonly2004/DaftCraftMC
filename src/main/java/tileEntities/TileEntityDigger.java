package tileEntities;

import keystuff.DaftcraftInfo;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockOre;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityFlowerPot;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

/**
 * Created with IntelliJ IDEA.
 * User: Daniel
 * Date: 09/08/14
 * Time: 03:16
 * To change this template use File | Settings | File Templates.
 */
public class TileEntityDigger extends TileEntity implements IInventory,IUpdatePlayerListBox
{
   private final int RESETTIMER=22;
   private int timer=RESETTIMER;
   private int count=1;
   private Block dugBlock;
   private ItemStack dugItem;
   private int numberOfSlots= DaftcraftInfo.DIGGERSLOTS;
   private BlockPos currentPos;
   private boolean isInventoryAbove;
   private Block blockUp;
   private TileEntityChest upChest;
   private int slot=0;//remove later if needing to see where it is called


   public TileEntityDigger()
   {
   }


   @Override
   public void update()
   {
      blockUp=this.worldObj.getBlockState(pos.up(1)).getBlock();
      if(blockUp != null)
      {
         if(blockUp instanceof BlockChest)
         {
            upChest=(TileEntityChest)this.worldObj.getTileEntity(pos.up(1));
            System.out.println("there is an inventory above");
            isInventoryAbove=true;
         }
         else
         {
            isInventoryAbove=false;
         }


      }
      else
      {
         isInventoryAbove=false;
      }

      if(!worldObj.isRemote && canRun(this.worldObj,this.pos))
      {

         timer--;

         if(timer==0)
         {

            dugBlock=worldObj.getBlockState(pos.down(count)).getBlock();
            if(dugBlock!=null)
            {
               if(dugBlock.getBlockHardness(this.worldObj,pos)> 0)
               {
                  if(dugBlock instanceof BlockOre)
                  {
                     dugItem=new ItemStack(dugBlock);

                     slot=findFreeSpace(dugItem);



                     if(slot != -1)
                     {
                        worldObj.setBlockToAir(pos.down(count));
                        setInventory(dugItem,slot);
                        setInventorySlotContents(slot,dugItem);
                     }
                     else
                     {
                        worldObj.destroyBlock(pos.down(count), true);
                     }

                     //setInventorySlotContents(0,dugItem);

                  }
                  else
                  {
                     worldObj.setBlockToAir(pos.down(count));
                  }


                  count++;

               }

               timer=RESETTIMER;



            }

            if(isInventoryAbove)
            {
               for(int count=0;count<items.length;count++)
               {
                  if(items[count]!= null)
                  {
                     int slot = findInventoryChest(upChest, items[count]);
                     if (slot >= 0) {
                        ((IInventory) blockUp).setInventorySlotContents(slot, items[count]);
                     }
                  }
               }
            }
         }
      }

   }

   /*@Override
   public void updateEntity()
   {




   } */



   public ItemStack setInventory(ItemStack stack,int slot)
   {
      if(items[slot]!= null && stack != null)
      {
         if (items[slot].getItem() == stack.getItem())
         {
            stack.stackSize=items[slot].stackSize+stack.stackSize;
         }
      }
      return stack;
   }

   public int findInventoryChest(TileEntityChest pBlock,ItemStack pItem)
   {
      boolean found=false;
      int count=0;

      if(pItem != null) {
         if (pBlock != null) {
            do {

               if ((pBlock).getStackInSlot(count) == pItem) {
                  if (pItem.stackSize + ((IInventory) pBlock).getStackInSlot(count).stackSize < dugItem.getMaxStackSize()) {
                     return count;
                  }
               }
               count++;
            } while (!found && count < ((IInventory) pBlock).getSizeInventory());
         }
      }
      return -1;
   }

   public int findFreeSpace(ItemStack dugItem)
   {

      for(int count=0;count<items.length;count++)
      {
         if(items[count]!= null)
         {
            if (items[count].getItem() == dugItem.getItem() && items[count].stackSize + dugItem.stackSize < dugItem.getMaxStackSize())
            {
               return count;
            }
         }
         if(items[count]==null)
         {
            return count;
         }
      }
      return -1;

   }

   public boolean canRun(World world,BlockPos pos)
   {
      TileEntityFurnace furnace;
      if(world.getTileEntity(pos.down(1)) instanceof  TileEntityFurnace && (world.getTileEntity(pos.up(1)) != null))
      {
         furnace=(TileEntityFurnace)world.getTileEntity(pos.up(1));
         if(furnace.isBurning())
         {
            return true;
         }
      }
      else if(world.getTileEntity(pos.west(1)) instanceof  TileEntityFurnace && (world.getTileEntity(pos.west(1)) != null))
      {
         furnace=(TileEntityFurnace)world.getTileEntity(pos.west(1));
         if(furnace.isBurning())
         {
            return true;
         }

      }
      else if(world.getTileEntity(pos.east(1)) instanceof  TileEntityFurnace && (world.getTileEntity(pos.east(1)) != null))
      {
         furnace=(TileEntityFurnace)world.getTileEntity(pos.east(1));
         if(furnace.isBurning())
         {
            return true;
         }
      }
      else if(world.getTileEntity(pos.north(1)) instanceof  TileEntityFurnace && (world.getTileEntity(pos.north(1)) != null))
      {
         furnace=(TileEntityFurnace)world.getTileEntity(pos.north(1));
         if(furnace.isBurning())
         {
            return true;
         }
      }
      else if(world.getTileEntity(pos.south(1)) instanceof  TileEntityFurnace && (world.getTileEntity(pos.south(1)) != null))
      {

         furnace=(TileEntityFurnace)world.getTileEntity(pos.south(1));
         if(furnace.isBurning())
         {
            return true;
         }
      }

         return false;
   }



   @Override
   public void writeToNBT(NBTTagCompound compound)
   {
      super.writeToNBT(compound);

      NBTTagList tagList=new NBTTagList();

      for(int count=0;count<getSizeInventory();count++)
      {
          ItemStack stack=getStackInSlot(count);

         if(this.items[count] != null)
         {
            NBTTagCompound item = new NBTTagCompound();
            item.setByte("Slot", (byte)count);
            this.items[count].writeToNBT(item);
            tagList.appendTag(item);
         }
      }
      compound.setTag("Items",tagList);
      compound.setInteger("Count",count);

   }

   @Override
   public void readFromNBT(NBTTagCompound compound)
   {
      super.readFromNBT(compound);

      NBTTagList tagList=compound.getTagList("Items",10);
      this.items = new ItemStack[this.getSizeInventory()];
      count=compound.getInteger("Count");


      for(int count=0;count< tagList.tagCount();count++)
      {
         NBTTagCompound item=tagList.getCompoundTagAt(count);
         int slot=item.getByte("Slot") &255;

         if(slot >=0 && slot<getSizeInventory())
         {
            //setInventorySlotContents(slot,ItemStack.loadItemStackFromNBT(item));
            this.items[count]=ItemStack.loadItemStackFromNBT(item);
         }
      }
   }

   ItemStack items[]=new ItemStack[numberOfSlots];

   @Override
   public int getSizeInventory()
   {
   return items.length;
   }

   @Override
   public ItemStack getStackInSlot(int slot)
   {
      return items[slot];
   }

   @Override
   public ItemStack decrStackSize(int slot, int count)
   {
      ItemStack itemstack=getStackInSlot(slot);

      if(itemstack !=null)
      {
         if(itemstack.stackSize <= count)
         {
           setInventorySlotContents(slot,null);
         }
         else
         {
            itemstack =itemstack.splitStack(count);
         }
      }

      return itemstack;
   }

   @Override
   public ItemStack getStackInSlotOnClosing(int slot)
   {
      ItemStack itemstack=getStackInSlot(slot);
      setInventorySlotContents(slot,null);
      return itemstack;
   }


   @Override
   public void setInventorySlotContents(int slot, ItemStack itemStack)
   {
     /* if(items[slot]!=null)
      {
         if (items[slot].getItem() == itemStack.getItem())
         {
            items[slot].stackSize += itemStack.stackSize;
         }
      }
      else
      {
         items[slot]=itemStack;
      }  */

      items[slot]=itemStack;
      if(itemStack !=null && itemStack.stackSize > getInventoryStackLimit())
      {
         itemStack.stackSize=getInventoryStackLimit();
      }
   }


   @Override
   public int getInventoryStackLimit() {
      return 64;
   }

   @Override
   public boolean isUseableByPlayer(EntityPlayer player)
   {

      return player.getDistance(pos.getX()+0.5,pos.getY()+0.5,pos.getZ()+0.5)<=64;
   }

   @Override
   public void openInventory(EntityPlayer player) {

   }

   @Override
   public void closeInventory(EntityPlayer player) {

   }

   @Override
   public boolean isItemValidForSlot(int p_94041_1_, ItemStack itemStack)
   {
      if(itemStack != null)
      {
         return true;
      }
      return false;
   }

   @Override
   public int getField(int id) {
      return 0;
   }

   @Override
   public void setField(int id, int value) {

   }

   @Override
   public int getFieldCount() {
      return 0;
   }

   @Override
   public void clear() {

   }


   @Override
   public String getName() {
      return null;
   }

   @Override
   public boolean hasCustomName() {
      return false;
   }

   @Override
   public IChatComponent getDisplayName() {
      return null;
   }
}//class
