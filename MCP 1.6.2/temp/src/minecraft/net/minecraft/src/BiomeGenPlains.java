package net.minecraft.src;

import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.EntityHorse;
import net.minecraft.src.SpawnListEntry;

public class BiomeGenPlains extends BiomeGenBase {

   protected BiomeGenPlains(int p_i1986_1_) {
      super(p_i1986_1_);
      this.field_76762_K.add(new SpawnListEntry(EntityHorse.class, 5, 2, 6));
      this.field_76760_I.field_76832_z = -999;
      this.field_76760_I.field_76802_A = 4;
      this.field_76760_I.field_76803_B = 10;
   }
}
