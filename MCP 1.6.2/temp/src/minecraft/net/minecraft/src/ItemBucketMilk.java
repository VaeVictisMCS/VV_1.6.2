package net.minecraft.src;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumAction;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class ItemBucketMilk extends Item {

   public ItemBucketMilk(int p_i1886_1_) {
      super(p_i1886_1_);
      this.func_77625_d(1);
      this.func_77637_a(CreativeTabs.field_78026_f);
   }

   public ItemStack func_77654_b(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_) {
      if(!p_77654_3_.field_71075_bZ.field_75098_d) {
         --p_77654_1_.field_77994_a;
      }

      if(!p_77654_2_.field_72995_K) {
         p_77654_3_.func_70674_bp();
      }

      return p_77654_1_.field_77994_a <= 0?new ItemStack(Item.field_77788_aw):p_77654_1_;
   }

   public int func_77626_a(ItemStack p_77626_1_) {
      return 32;
   }

   public EnumAction func_77661_b(ItemStack p_77661_1_) {
      return EnumAction.drink;
   }

   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
      p_77659_3_.func_71008_a(p_77659_1_, this.func_77626_a(p_77659_1_));
      return p_77659_1_;
   }
}
