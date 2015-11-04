package blocks;

import config.DaftcraftConfig;
import entities.EntityHerobrine;
import keystuff.DaftcraftAchievements;
import keystuff.myMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.EnchantmentProtection;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import java.util.Iterator;
import java.util.List;


public class TheSummonor extends Block
{

   //add in blindness for all players nearby when herobrine is spawned...possibly all will see
   private boolean endOnly;

   public TheSummonor(Material material)
   {
      super(material);
      setUnlocalizedName("the summoner");
      setCreativeTab(myMod.daftcraft);
      setHardness(1.0f);


   }




  public void dragonSpawn(World world,int x,int y,int z)
  {

  }


   @Override
   public void onNeighborBlockChange(World world, BlockPos pos, IBlockState state, Block neighborBlock)
   {
      EntityPlayer player;

      //items checked for in spawning dragon
      Block dragonSpawnOne=Blocks.diamond_block;
      Block dragonSpawnTwo=Blocks.obsidian;
      Block dragonSpawnThree=Blocks.beacon;

      //items checked for when swpawning the wither (possibly change)
      Block witherSpawn=Blocks.soul_sand;

      Block herobrineSpawn=Blocks.beacon;
      Block herobrineSpawnTwo=Blocks.diamond_block;


      if(!world.isRemote)
      {
         if(world.isBlockIndirectlyGettingPowered(pos)>0)
         {



            if(DaftcraftConfig.endOnly && !DaftcraftConfig.dragonDisabled)
            {
               if(world.provider.getDimensionId()==1)
               {                            //x,y+1,z
                  if(world.getBlockState(pos.up(1)).getBlock()==dragonSpawnThree)
                  {                          //x,y,z+1
                     if(world.getBlockState(pos.north(1)).getBlock()==dragonSpawnOne && world.getBlockState(pos.south(1)).getBlock()==dragonSpawnOne)
                     {                          //x+1,y,z                                                        x-1,y,z
                        if(world.getBlockState(pos.east(1)).getBlock()==dragonSpawnTwo && world.getBlockState(pos.west(1)).getBlock()==dragonSpawnTwo)
                        {
                           EntityDragon dragon=new EntityDragon(world);

                           dragon.setPosition((double)pos.getX(),(double)pos.getY()+5,(double)pos.getZ());
                           world.spawnEntityInWorld(dragon);

                           world.destroyBlock(pos, true);
                           world.destroyBlock(pos.east(1), true);
                           world.destroyBlock(pos.west(1), true);
                           world.destroyBlock(pos.north(1), true);
                           world.destroyBlock(pos.south(1), true);
                           world.destroyBlock(pos.up(1), true);
                           world.createExplosion(null,pos.getX(),pos.getY(),pos.getZ(),2.0f,true);

                        }
                     }
                                                  //x,y,z+1                                                       x,y,z-1
                     else if(world.getBlockState(pos.north(1)).getBlock()==dragonSpawnTwo && world.getBlockState(pos.south(1)).getBlock()==dragonSpawnTwo)
                     {
                                                  //x+1,y,z                                                     x-1,y,z
                        if(world.getBlockState(pos.east(1)).getBlock()==dragonSpawnOne && world.getBlockState(pos.west(1)).getBlock()==dragonSpawnOne)
                        {
                           EntityDragon dragon=new EntityDragon(world);
                           dragon.setPosition((double)pos.getX(),(double)pos.getY()+5,(double)pos.getZ());
                           world.spawnEntityInWorld(dragon);

                           world.destroyBlock(pos, true);
                           world.destroyBlock(pos.east(1), true);
                           world.destroyBlock(pos.west(1), true);
                           world.destroyBlock(pos.north(1), true);
                           world.destroyBlock(pos.south(1), true);
                           world.destroyBlock(pos.up(1), true);
                           world.createExplosion(null,pos.getX(),pos.getY(),pos.getZ(),2.0f,true);




                        }
                     }
                  }

               }
            }
            else if(!DaftcraftConfig.endOnly && !DaftcraftConfig.dragonDisabled)
            {                            //x,y+1,z
               if(world.getBlockState(pos.up(1)).getBlock()==dragonSpawnThree)
               {
                  if(world.getBlockState(pos.north(1)).getBlock()==dragonSpawnOne && world.getBlockState(pos.south(1)).getBlock()==dragonSpawnOne)
                  {
                     if(world.getBlockState(pos.east(1)).getBlock()==dragonSpawnTwo && world.getBlockState(pos.west(1)).getBlock()==dragonSpawnTwo)
                     {
                        EntityDragon dragon=new EntityDragon(world);
                        dragon.setPosition((double) pos.getX(), (double) pos.getY() + 5, (double) pos.getZ());
                        world.spawnEntityInWorld(dragon);

                        world.destroyBlock(pos, true);//x,y,z
                        world.destroyBlock(pos.east(1), true);  //x+1,y,z
                        world.destroyBlock(pos.west(1), true);  //x-1,y,z
                        world.destroyBlock(pos.north(1), true); //x,y,z+1
                        world.destroyBlock(pos.south(1), true); //x,y,z-1
                        world.destroyBlock(pos.up(1), true);    //x,y+1,z
                        world.createExplosion(null,pos.getX(),pos.getY(),pos.getZ(),2.0f,true);

                     }
                  }
                                                   //x,y,z+1                                             x,y,z-1
                  else if(world.getBlockState(pos.north(1)).getBlock()==dragonSpawnTwo && world.getBlockState(pos.south(1)).getBlock()==dragonSpawnTwo)
                  {
                                                //x+1,y,z                                                     x-1,y,z
                     if(world.getBlockState(pos.east(1)).getBlock()==dragonSpawnOne && world.getBlockState(pos.west(1)).getBlock()==dragonSpawnOne)
                     {

                        EntityDragon dragon=new EntityDragon(world);
                        dragon.setPosition((double)pos.getX(),(double)pos.getY()+5,(double)pos.getZ());
                        world.spawnEntityInWorld(dragon);

                        world.destroyBlock(pos, true);
                        world.destroyBlock(pos.east(1), true);
                        world.destroyBlock(pos.west(1), true);
                        world.destroyBlock(pos.north(1), true);
                        world.destroyBlock(pos.south(1), true);
                        world.destroyBlock(pos.up(1), true);
                        world.createExplosion(null,pos.getX(),pos.getY(),pos.getZ(),2.0f,true);




                     }
                  }
               }

            }


            if(!DaftcraftConfig.witherDisabled)
            {                           //x,y-1,z                                                    x,y-2,z                                                    x-1,y-1,z                                                            x+1,y-1,z
               if(world.getBlockState(pos.down(1)).getBlock()==witherSpawn && world.getBlockState(pos.down(2)).getBlock()==witherSpawn && world.getBlockState(pos.west(1).down(1)).getBlock()==witherSpawn && world.getBlockState(pos.east(1).down(1)).getBlock()==witherSpawn)
               {
                  //EntityPlayer player= Minecraft.getMinecraft().thePlayer;
                  EntityWither wither=new EntityWither(world);
                  wither.setPosition(pos.getX(), pos.getY(), pos.getZ());
                  world.spawnEntityInWorld(wither);

                  wither.setPosition((double)pos.getX(),(double)pos.getY()+1,(double)pos.getZ());
                  world.destroyBlock(pos.down(1), true); //y-1
                  world.destroyBlock(pos, true);   //x,y,z
                  world.destroyBlock(pos.down(2), true); //y-2
                  world.destroyBlock(pos.west(1).down(1), true);  //x-1,y-1
                  world.destroyBlock(pos.east(1).down(1), true);  //x+1,y-1
                  world.createExplosion(null,pos.getX(),pos.getY(),pos.getZ(),2.0f,true);

               }                                                                                                                                                        //y-1,z-1                                           y-1,z+1
               else if(world.getBlockState(pos.down(1)).getBlock()==witherSpawn && world.getBlockState(pos.down(2)).getBlock()==witherSpawn && world.getBlockState(pos.down(1).south(1)).getBlock()==witherSpawn && world.getBlockState(pos.down(1).north(1)).getBlock()==witherSpawn)
               {
                  EntityWither wither=new EntityWither(world);
                  wither.setPosition(pos.getX(),pos.getY(),pos.getZ());
                  world.spawnEntityInWorld(wither);
                  world.destroyBlock(pos.south(1), true);  //y-1
                  world.destroyBlock(pos ,true);   //x,y,z
                  world.destroyBlock(pos.south(2), true);  //y-2
                  world.destroyBlock(pos.down(1).south(1), true); //y-1,z-1
                  world.destroyBlock(pos.down(1).north(1), true);   //y-1,z+1
                  world.createExplosion(null, pos.getX(),pos.getY(),pos.getZ(), 2.0f, true);

               }
            }


            EntityHerobrine herobrine=null;

            //pos x-1,y,z-1
            if(world.getBlockState(pos.west(1).south(1)).getBlock()==herobrineSpawn && world.getBlockState(pos.east(1).south(1)).getBlock()==herobrineSpawn && world.getBlockState(pos.west(1).north(1)).getBlock()==herobrineSpawn && world.getBlockState(pos.north(1).east(1)).getBlock()==herobrineSpawn)
            {


               if(world.getBlockState(pos.west(1)).getBlock()==herobrineSpawnTwo && world.getBlockState(pos.east(1)).getBlock()==herobrineSpawnTwo && world.getBlockState(pos.north(1)).getBlock()==herobrineSpawnTwo && world.getBlockState(pos.south(1)).getBlock()==herobrineSpawnTwo){
                  {

                     if(world.getBlockState(pos.up(1)).getBlock()==Blocks.dragon_egg)
                     {



                        if(!world.isRemote)
                        {

                           herobrine=new EntityHerobrine(world);
                           herobrine.setCurrentItemOrArmor(0,new ItemStack(Items.bow));
                           herobrine.setCurrentItemOrArmor(2,new ItemStack(Items.diamond_chestplate));
                           herobrine.setPositionAndUpdate(pos.getX(),pos.getY()+13,pos.getZ());

                           world.spawnEntityInWorld(herobrine);

                           player=world.getClosestPlayerToEntity(herobrine,25);
                           player.addStat(DaftcraftAchievements.summonHIM,1);
                           setEffects(world,pos);


                        }

                        for(int secX=-2;secX<3;secX++)
                        {
                           for(int secZ=-2;secZ<3;secZ++)
                           {
                              world.setBlockState(new BlockPos(pos.getX()+secX,pos.getY()+10,pos.getZ()+secZ),Blocks.obsidian.getDefaultState());
                           }

                        }

                        for(int thirdX=-1;thirdX<2;thirdX++)
                        {
                           for(int thirdZ=-1;thirdZ<2;thirdZ++)
                           {
                              world.setBlockState((new BlockPos(pos.getX() + thirdX, pos.getY() + 11, pos.getZ() + thirdZ)), Blocks.obsidian.getDefaultState());

                              if(thirdX!=0 && thirdZ!=0)
                              {
                                 world.setBlockState(new BlockPos(pos.getX()+thirdX,pos.getY()+12,pos.getZ()+thirdZ), Blocks.redstone_torch.getDefaultState());
                              }



                           }

                           EntitySkeleton skeleton=new EntitySkeleton(world);
                           skeleton.setCurrentItemOrArmor(0,new ItemStack(Items.diamond_sword));
                           skeleton.setCurrentItemOrArmor(1,new ItemStack(Items.golden_boots));
                           skeleton.setCurrentItemOrArmor(2,new ItemStack(Items.golden_leggings));
                           skeleton.setCurrentItemOrArmor(3,new ItemStack(Items.golden_chestplate));
                           skeleton.setCurrentItemOrArmor(4,new ItemStack(Items.golden_helmet));


                           skeleton.setSkeletonType(1);
                           skeleton.setPosition(pos.getX(),pos.getY(),pos.getZ()+thirdX);


                           world.spawnEntityInWorld(skeleton);
                        }
                        world.setBlockState(pos.up(12), Blocks.obsidian.getDefaultState());




                        for(int X=-1;X<2;X++)
                        {
                           for(int Z=-1;Z<2;Z++)
                           {
                              world.destroyBlock(new BlockPos(pos.getX()+X,pos.getY(),pos.getZ()+Z), true);
                           }

                        }

                        world.destroyBlock(pos.up(1), true);
                        world.createExplosion(null,pos.getX(),pos.getY(),pos.getZ(),2,true);



                     }

                  }


               }

            }

         }


      }
   }



   public void setEffects(World world,BlockPos pos)
   {
      int X=pos.getX();
      int Y=pos.getY();
      int Z=pos.getZ();
      AxisAlignedBB axisalignedbb = AxisAlignedBB.fromBounds((double)X,(double) Y,(double)Z,(double) X+ 1,(double) Y+ 1,(double)Z+ 1).expand(10.0D, 5.0D, 10.0D);
      //axisalignedbb.maxY = (double)world.getHeight();
      List list = world.getEntitiesWithinAABB(EntityPlayer.class, axisalignedbb);
      Iterator iterator = list.iterator();
      EntityPlayer entityPlayer;

      while (iterator.hasNext())
      {
         entityPlayer = (EntityPlayer)iterator.next();
         entityPlayer.addPotionEffect(new PotionEffect(Potion.blindness.id,200,10));
         entityPlayer.addPotionEffect(new PotionEffect(Potion.nightVision.id,200,10));
      }


   }
}












