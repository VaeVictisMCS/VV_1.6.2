package net.minecraft.src;

import net.minecraft.src.EntityAITarget;
import net.minecraft.src.EntityLivingBase;
import net.minecraft.src.EntityTameable;

public class EntityAIOwnerHurtByTarget extends EntityAITarget {

   EntityTameable field_75316_a;
   EntityLivingBase field_75315_b;
   private int field_142051_e;


   public EntityAIOwnerHurtByTarget(EntityTameable p_i1667_1_) {
      super(p_i1667_1_, false);
      this.field_75316_a = p_i1667_1_;
      this.func_75248_a(1);
   }

   public boolean func_75250_a() {
      if(!this.field_75316_a.func_70909_n()) {
         return false;
      } else {
         EntityLivingBase var1 = this.field_75316_a.func_130012_q();
         if(var1 == null) {
            return false;
         } else {
            this.field_75315_b = var1.func_70643_av();
            int var2 = var1.func_142015_aE();
            return var2 != this.field_142051_e && this.func_75296_a(this.field_75315_b, false) && this.field_75316_a.func_142018_a(this.field_75315_b, var1);
         }
      }
   }

   public void func_75249_e() {
      this.field_75299_d.func_70624_b(this.field_75315_b);
      EntityLivingBase var1 = this.field_75316_a.func_130012_q();
      if(var1 != null) {
         this.field_142051_e = var1.func_142015_aE();
      }

      super.func_75249_e();
   }
}
