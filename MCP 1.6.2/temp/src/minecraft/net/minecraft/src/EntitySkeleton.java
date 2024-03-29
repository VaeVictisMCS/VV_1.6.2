package net.minecraft.src;

import java.util.Calendar;
import net.minecraft.src.AchievementList;
import net.minecraft.src.Block;
import net.minecraft.src.DamageSource;
import net.minecraft.src.Enchantment;
import net.minecraft.src.EnchantmentHelper;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityAIArrowAttack;
import net.minecraft.src.EntityAIAttackOnCollide;
import net.minecraft.src.EntityAIFleeSun;
import net.minecraft.src.EntityAIHurtByTarget;
import net.minecraft.src.EntityAILookIdle;
import net.minecraft.src.EntityAINearestAttackableTarget;
import net.minecraft.src.EntityAIRestrictSun;
import net.minecraft.src.EntityAISwimming;
import net.minecraft.src.EntityAIWander;
import net.minecraft.src.EntityAIWatchClosest;
import net.minecraft.src.EntityArrow;
import net.minecraft.src.EntityCreature;
import net.minecraft.src.EntityLivingBase;
import net.minecraft.src.EntityLivingData;
import net.minecraft.src.EntityMob;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumCreatureAttribute;
import net.minecraft.src.IRangedAttackMob;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.Potion;
import net.minecraft.src.PotionEffect;
import net.minecraft.src.SharedMonsterAttributes;
import net.minecraft.src.World;
import net.minecraft.src.WorldProviderHell;

public class EntitySkeleton extends EntityMob implements IRangedAttackMob {

   private EntityAIArrowAttack field_85037_d = new EntityAIArrowAttack(this, 1.0D, 20, 60, 15.0F);
   private EntityAIAttackOnCollide field_85038_e = new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.2D, false);


   public EntitySkeleton(World p_i1741_1_) {
      super(p_i1741_1_);
      this.field_70714_bg.func_75776_a(1, new EntityAISwimming(this));
      this.field_70714_bg.func_75776_a(2, new EntityAIRestrictSun(this));
      this.field_70714_bg.func_75776_a(3, new EntityAIFleeSun(this, 1.0D));
      this.field_70714_bg.func_75776_a(5, new EntityAIWander(this, 1.0D));
      this.field_70714_bg.func_75776_a(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
      this.field_70714_bg.func_75776_a(6, new EntityAILookIdle(this));
      this.field_70715_bh.func_75776_a(1, new EntityAIHurtByTarget(this, false));
      this.field_70715_bh.func_75776_a(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
      if(p_i1741_1_ != null && !p_i1741_1_.field_72995_K) {
         this.func_85036_m();
      }

   }

   protected void func_110147_ax() {
      super.func_110147_ax();
      this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.25D);
   }

   protected void func_70088_a() {
      super.func_70088_a();
      this.field_70180_af.func_75682_a(13, new Byte((byte)0));
   }

   public boolean func_70650_aV() {
      return true;
   }

   protected String func_70639_aQ() {
      return "mob.skeleton.say";
   }

   protected String func_70621_aR() {
      return "mob.skeleton.hurt";
   }

   protected String func_70673_aS() {
      return "mob.skeleton.death";
   }

   protected void func_70036_a(int p_70036_1_, int p_70036_2_, int p_70036_3_, int p_70036_4_) {
      this.func_85030_a("mob.skeleton.step", 0.15F, 1.0F);
   }

   public boolean func_70652_k(Entity p_70652_1_) {
      if(super.func_70652_k(p_70652_1_)) {
         if(this.func_82202_m() == 1 && p_70652_1_ instanceof EntityLivingBase) {
            ((EntityLivingBase)p_70652_1_).func_70690_d(new PotionEffect(Potion.field_82731_v.field_76415_H, 200));
         }

         return true;
      } else {
         return false;
      }
   }

   public EnumCreatureAttribute func_70668_bt() {
      return EnumCreatureAttribute.UNDEAD;
   }

   public void func_70636_d() {
      if(this.field_70170_p.func_72935_r() && !this.field_70170_p.field_72995_K) {
         float var1 = this.func_70013_c(1.0F);
         if(var1 > 0.5F && this.field_70146_Z.nextFloat() * 30.0F < (var1 - 0.4F) * 2.0F && this.field_70170_p.func_72937_j(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70163_u), MathHelper.func_76128_c(this.field_70161_v))) {
            boolean var2 = true;
            ItemStack var3 = this.func_71124_b(4);
            if(var3 != null) {
               if(var3.func_77984_f()) {
                  var3.func_77964_b(var3.func_77952_i() + this.field_70146_Z.nextInt(2));
                  if(var3.func_77952_i() >= var3.func_77958_k()) {
                     this.func_70669_a(var3);
                     this.func_70062_b(4, (ItemStack)null);
                  }
               }

               var2 = false;
            }

            if(var2) {
               this.func_70015_d(8);
            }
         }
      }

      if(this.field_70170_p.field_72995_K && this.func_82202_m() == 1) {
         this.func_70105_a(0.72F, 2.34F);
      }

      super.func_70636_d();
   }

   public void func_70098_U() {
      super.func_70098_U();
      if(this.field_70154_o instanceof EntityCreature) {
         EntityCreature var1 = (EntityCreature)this.field_70154_o;
         this.field_70761_aq = var1.field_70761_aq;
      }

   }

   public void func_70645_a(DamageSource p_70645_1_) {
      super.func_70645_a(p_70645_1_);
      if(p_70645_1_.func_76364_f() instanceof EntityArrow && p_70645_1_.func_76346_g() instanceof EntityPlayer) {
         EntityPlayer var2 = (EntityPlayer)p_70645_1_.func_76346_g();
         double var3 = var2.field_70165_t - this.field_70165_t;
         double var5 = var2.field_70161_v - this.field_70161_v;
         if(var3 * var3 + var5 * var5 >= 2500.0D) {
            var2.func_71029_a(AchievementList.field_76020_v);
         }
      }

   }

   protected int func_70633_aT() {
      return Item.field_77704_l.field_77779_bT;
   }

   protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
      int var3;
      int var4;
      if(this.func_82202_m() == 1) {
         var3 = this.field_70146_Z.nextInt(3 + p_70628_2_) - 1;

         for(var4 = 0; var4 < var3; ++var4) {
            this.func_70025_b(Item.field_77705_m.field_77779_bT, 1);
         }
      } else {
         var3 = this.field_70146_Z.nextInt(3 + p_70628_2_);

         for(var4 = 0; var4 < var3; ++var4) {
            this.func_70025_b(Item.field_77704_l.field_77779_bT, 1);
         }
      }

      var3 = this.field_70146_Z.nextInt(3 + p_70628_2_);

      for(var4 = 0; var4 < var3; ++var4) {
         this.func_70025_b(Item.field_77755_aX.field_77779_bT, 1);
      }

   }

   protected void func_70600_l(int p_70600_1_) {
      if(this.func_82202_m() == 1) {
         this.func_70099_a(new ItemStack(Item.field_82799_bQ.field_77779_bT, 1, 1), 0.0F);
      }

   }

   protected void func_82164_bB() {
      super.func_82164_bB();
      this.func_70062_b(0, new ItemStack(Item.field_77707_k));
   }

   public EntityLivingData func_110161_a(EntityLivingData p_110161_1_) {
      p_110161_1_ = super.func_110161_a(p_110161_1_);
      if(this.field_70170_p.field_73011_w instanceof WorldProviderHell && this.func_70681_au().nextInt(5) > 0) {
         this.field_70714_bg.func_75776_a(4, this.field_85038_e);
         this.func_82201_a(1);
         this.func_70062_b(0, new ItemStack(Item.field_77711_v));
         this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(4.0D);
      } else {
         this.field_70714_bg.func_75776_a(4, this.field_85037_d);
         this.func_82164_bB();
         this.func_82162_bC();
      }

      this.func_98053_h(this.field_70146_Z.nextFloat() < 0.55F * this.field_70170_p.func_110746_b(this.field_70165_t, this.field_70163_u, this.field_70161_v));
      if(this.func_71124_b(4) == null) {
         Calendar var2 = this.field_70170_p.func_83015_S();
         if(var2.get(2) + 1 == 10 && var2.get(5) == 31 && this.field_70146_Z.nextFloat() < 0.25F) {
            this.func_70062_b(4, new ItemStack(this.field_70146_Z.nextFloat() < 0.1F?Block.field_72008_bf:Block.field_72061_ba));
            this.field_82174_bp[4] = 0.0F;
         }
      }

      return p_110161_1_;
   }

   public void func_85036_m() {
      this.field_70714_bg.func_85156_a(this.field_85038_e);
      this.field_70714_bg.func_85156_a(this.field_85037_d);
      ItemStack var1 = this.func_70694_bm();
      if(var1 != null && var1.field_77993_c == Item.field_77707_k.field_77779_bT) {
         this.field_70714_bg.func_75776_a(4, this.field_85037_d);
      } else {
         this.field_70714_bg.func_75776_a(4, this.field_85038_e);
      }

   }

   public void func_82196_d(EntityLivingBase p_82196_1_, float p_82196_2_) {
      EntityArrow var3 = new EntityArrow(this.field_70170_p, this, p_82196_1_, 1.6F, (float)(14 - this.field_70170_p.field_73013_u * 4));
      int var4 = EnchantmentHelper.func_77506_a(Enchantment.field_77345_t.field_77352_x, this.func_70694_bm());
      int var5 = EnchantmentHelper.func_77506_a(Enchantment.field_77344_u.field_77352_x, this.func_70694_bm());
      var3.func_70239_b((double)(p_82196_2_ * 2.0F) + this.field_70146_Z.nextGaussian() * 0.25D + (double)((float)this.field_70170_p.field_73013_u * 0.11F));
      if(var4 > 0) {
         var3.func_70239_b(var3.func_70242_d() + (double)var4 * 0.5D + 0.5D);
      }

      if(var5 > 0) {
         var3.func_70240_a(var5);
      }

      if(EnchantmentHelper.func_77506_a(Enchantment.field_77343_v.field_77352_x, this.func_70694_bm()) > 0 || this.func_82202_m() == 1) {
         var3.func_70015_d(100);
      }

      this.func_85030_a("random.bow", 1.0F, 1.0F / (this.func_70681_au().nextFloat() * 0.4F + 0.8F));
      this.field_70170_p.func_72838_d(var3);
   }

   public int func_82202_m() {
      return this.field_70180_af.func_75683_a(13);
   }

   public void func_82201_a(int p_82201_1_) {
      this.field_70180_af.func_75692_b(13, Byte.valueOf((byte)p_82201_1_));
      this.field_70178_ae = p_82201_1_ == 1;
      if(p_82201_1_ == 1) {
         this.func_70105_a(0.72F, 2.34F);
      } else {
         this.func_70105_a(0.6F, 1.8F);
      }

   }

   public void func_70037_a(NBTTagCompound p_70037_1_) {
      super.func_70037_a(p_70037_1_);
      if(p_70037_1_.func_74764_b("SkeletonType")) {
         byte var2 = p_70037_1_.func_74771_c("SkeletonType");
         this.func_82201_a(var2);
      }

      this.func_85036_m();
   }

   public void func_70014_b(NBTTagCompound p_70014_1_) {
      super.func_70014_b(p_70014_1_);
      p_70014_1_.func_74774_a("SkeletonType", (byte)this.func_82202_m());
   }

   public void func_70062_b(int p_70062_1_, ItemStack p_70062_2_) {
      super.func_70062_b(p_70062_1_, p_70062_2_);
      if(!this.field_70170_p.field_72995_K && p_70062_1_ == 0) {
         this.func_85036_m();
      }

   }

   public double func_70033_W() {
      return super.func_70033_W() - 0.5D;
   }
}
