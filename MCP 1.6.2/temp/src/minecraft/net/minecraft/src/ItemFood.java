package net.minecraft.src;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumAction;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.PotionEffect;
import net.minecraft.src.World;

public class ItemFood extends Item {

   public final int field_77855_a;
   private final int field_77853_b;
   private final float field_77854_c;
   private final boolean field_77856_bY;
   private boolean field_77852_bZ;
   private int field_77851_ca;
   private int field_77850_cb;
   private int field_77857_cc;
   private float field_77858_cd;


   public ItemFood(int p_i1868_1_, int p_i1868_2_, float p_i1868_3_, boolean p_i1868_4_) {
      super(p_i1868_1_);
      this.field_77855_a = 32;
      this.field_77853_b = p_i1868_2_;
      this.field_77856_bY = p_i1868_4_;
      this.field_77854_c = p_i1868_3_;
      this.func_77637_a(CreativeTabs.field_78039_h);
   }

   public ItemFood(int p_i1869_1_, int p_i1869_2_, boolean p_i1869_3_) {
      this(p_i1869_1_, p_i1869_2_, 0.6F, p_i1869_3_);
   }

   public ItemStack func_77654_b(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_) {
      --p_77654_1_.field_77994_a;
      p_77654_3_.func_71024_bL().func_75111_a(this);
      p_77654_2_.func_72956_a(p_77654_3_, "random.burp", 0.5F, p_77654_2_.field_73012_v.nextFloat() * 0.1F + 0.9F);
      this.func_77849_c(p_77654_1_, p_77654_2_, p_77654_3_);
      return p_77654_1_;
   }

   protected void func_77849_c(ItemStack p_77849_1_, World p_77849_2_, EntityPlayer p_77849_3_) {
      if(!p_77849_2_.field_72995_K && this.field_77851_ca > 0 && p_77849_2_.field_73012_v.nextFloat() < this.field_77858_cd) {
         p_77849_3_.func_70690_d(new PotionEffect(this.field_77851_ca, this.field_77850_cb * 20, this.field_77857_cc));
      }

   }

   public int func_77626_a(ItemStack p_77626_1_) {
      return 32;
   }

   public EnumAction func_77661_b(ItemStack p_77661_1_) {
      return EnumAction.eat;
   }

   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
      if(p_77659_3_.func_71043_e(this.field_77852_bZ)) {
         p_77659_3_.func_71008_a(p_77659_1_, this.func_77626_a(p_77659_1_));
      }

      return p_77659_1_;
   }

   public int func_77847_f() {
      return this.field_77853_b;
   }

   public float func_77846_g() {
      return this.field_77854_c;
   }

   public boolean func_77845_h() {
      return this.field_77856_bY;
   }

   public ItemFood func_77844_a(int p_77844_1_, int p_77844_2_, int p_77844_3_, float p_77844_4_) {
      this.field_77851_ca = p_77844_1_;
      this.field_77850_cb = p_77844_2_;
      this.field_77857_cc = p_77844_3_;
      this.field_77858_cd = p_77844_4_;
      return this;
   }

   public ItemFood func_77848_i() {
      this.field_77852_bZ = true;
      return this;
   }
}
