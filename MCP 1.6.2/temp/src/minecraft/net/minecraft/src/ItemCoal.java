package net.minecraft.src;

import java.util.List;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Icon;
import net.minecraft.src.IconRegister;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class ItemCoal extends Item {

   private Icon field_111220_a;


   public ItemCoal(int p_i1838_1_) {
      super(p_i1838_1_);
      this.func_77627_a(true);
      this.func_77656_e(0);
      this.func_77637_a(CreativeTabs.field_78035_l);
   }

   public String func_77667_c(ItemStack p_77667_1_) {
      return p_77667_1_.func_77960_j() == 1?"item.charcoal":"item.coal";
   }

   public void func_77633_a(int p_77633_1_, CreativeTabs p_77633_2_, List p_77633_3_) {
      p_77633_3_.add(new ItemStack(p_77633_1_, 1, 0));
      p_77633_3_.add(new ItemStack(p_77633_1_, 1, 1));
   }

   public Icon func_77617_a(int p_77617_1_) {
      return p_77617_1_ == 1?this.field_111220_a:super.func_77617_a(p_77617_1_);
   }

   public void func_94581_a(IconRegister p_94581_1_) {
      super.func_94581_a(p_94581_1_);
      this.field_111220_a = p_94581_1_.func_94245_a("charcoal");
   }
}
