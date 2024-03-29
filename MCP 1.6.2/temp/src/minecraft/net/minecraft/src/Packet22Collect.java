package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.src.NetHandler;
import net.minecraft.src.Packet;

public class Packet22Collect extends Packet {

   public int field_73313_a;
   public int field_73312_b;


   public Packet22Collect() {}

   public Packet22Collect(int p_i1479_1_, int p_i1479_2_) {
      this.field_73313_a = p_i1479_1_;
      this.field_73312_b = p_i1479_2_;
   }

   public void func_73267_a(DataInput p_73267_1_) throws IOException {
      this.field_73313_a = p_73267_1_.readInt();
      this.field_73312_b = p_73267_1_.readInt();
   }

   public void func_73273_a(DataOutput p_73273_1_) throws IOException {
      p_73273_1_.writeInt(this.field_73313_a);
      p_73273_1_.writeInt(this.field_73312_b);
   }

   public void func_73279_a(NetHandler p_73279_1_) {
      p_73279_1_.func_72475_a(this);
   }

   public int func_73284_a() {
      return 8;
   }
}
