package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import net.minecraft.server.MinecraftServer;
import net.minecraft.src.CompressedStreamTools;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IChunkLoader;
import net.minecraft.src.IPlayerFileData;
import net.minecraft.src.ISaveHandler;
import net.minecraft.src.MinecraftException;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.WorldInfo;
import net.minecraft.src.WorldProvider;

public class SaveHandler implements ISaveHandler, IPlayerFileData {

   private final File field_75770_b;
   private final File field_75771_c;
   private final File field_75768_d;
   private final long field_75769_e = MinecraftServer.func_130071_aq();
   private final String field_75767_f;


   public SaveHandler(File p_i2146_1_, String p_i2146_2_, boolean p_i2146_3_) {
      this.field_75770_b = new File(p_i2146_1_, p_i2146_2_);
      this.field_75770_b.mkdirs();
      this.field_75771_c = new File(this.field_75770_b, "players");
      this.field_75768_d = new File(this.field_75770_b, "data");
      this.field_75768_d.mkdirs();
      this.field_75767_f = p_i2146_2_;
      if(p_i2146_3_) {
         this.field_75771_c.mkdirs();
      }

      this.func_75766_h();
   }

   private void func_75766_h() {
      try {
         File var1 = new File(this.field_75770_b, "session.lock");
         DataOutputStream var2 = new DataOutputStream(new FileOutputStream(var1));

         try {
            var2.writeLong(this.field_75769_e);
         } finally {
            var2.close();
         }

      } catch (IOException var7) {
         var7.printStackTrace();
         throw new RuntimeException("Failed to check session lock, aborting");
      }
   }

   protected File func_75765_b() {
      return this.field_75770_b;
   }

   public void func_75762_c() throws MinecraftException {
      try {
         File var1 = new File(this.field_75770_b, "session.lock");
         DataInputStream var2 = new DataInputStream(new FileInputStream(var1));

         try {
            if(var2.readLong() != this.field_75769_e) {
               throw new MinecraftException("The save is being accessed from another location, aborting");
            }
         } finally {
            var2.close();
         }

      } catch (IOException var7) {
         throw new MinecraftException("Failed to check session lock, aborting");
      }
   }

   public IChunkLoader func_75763_a(WorldProvider p_75763_1_) {
      throw new RuntimeException("Old Chunk Storage is no longer supported.");
   }

   public WorldInfo func_75757_d() {
      File var1 = new File(this.field_75770_b, "level.dat");
      NBTTagCompound var2;
      NBTTagCompound var3;
      if(var1.exists()) {
         try {
            var2 = CompressedStreamTools.func_74796_a(new FileInputStream(var1));
            var3 = var2.func_74775_l("Data");
            return new WorldInfo(var3);
         } catch (Exception var5) {
            var5.printStackTrace();
         }
      }

      var1 = new File(this.field_75770_b, "level.dat_old");
      if(var1.exists()) {
         try {
            var2 = CompressedStreamTools.func_74796_a(new FileInputStream(var1));
            var3 = var2.func_74775_l("Data");
            return new WorldInfo(var3);
         } catch (Exception var4) {
            var4.printStackTrace();
         }
      }

      return null;
   }

   public void func_75755_a(WorldInfo p_75755_1_, NBTTagCompound p_75755_2_) {
      NBTTagCompound var3 = p_75755_1_.func_76082_a(p_75755_2_);
      NBTTagCompound var4 = new NBTTagCompound();
      var4.func_74782_a("Data", var3);

      try {
         File var5 = new File(this.field_75770_b, "level.dat_new");
         File var6 = new File(this.field_75770_b, "level.dat_old");
         File var7 = new File(this.field_75770_b, "level.dat");
         CompressedStreamTools.func_74799_a(var4, new FileOutputStream(var5));
         if(var6.exists()) {
            var6.delete();
         }

         var7.renameTo(var6);
         if(var7.exists()) {
            var7.delete();
         }

         var5.renameTo(var7);
         if(var5.exists()) {
            var5.delete();
         }
      } catch (Exception var8) {
         var8.printStackTrace();
      }

   }

   public void func_75761_a(WorldInfo p_75761_1_) {
      NBTTagCompound var2 = p_75761_1_.func_76066_a();
      NBTTagCompound var3 = new NBTTagCompound();
      var3.func_74782_a("Data", var2);

      try {
         File var4 = new File(this.field_75770_b, "level.dat_new");
         File var5 = new File(this.field_75770_b, "level.dat_old");
         File var6 = new File(this.field_75770_b, "level.dat");
         CompressedStreamTools.func_74799_a(var3, new FileOutputStream(var4));
         if(var5.exists()) {
            var5.delete();
         }

         var6.renameTo(var5);
         if(var6.exists()) {
            var6.delete();
         }

         var4.renameTo(var6);
         if(var4.exists()) {
            var4.delete();
         }
      } catch (Exception var7) {
         var7.printStackTrace();
      }

   }

   public void func_75753_a(EntityPlayer p_75753_1_) {
      try {
         NBTTagCompound var2 = new NBTTagCompound();
         p_75753_1_.func_70109_d(var2);
         File var3 = new File(this.field_75771_c, p_75753_1_.func_70005_c_() + ".dat.tmp");
         File var4 = new File(this.field_75771_c, p_75753_1_.func_70005_c_() + ".dat");
         CompressedStreamTools.func_74799_a(var2, new FileOutputStream(var3));
         if(var4.exists()) {
            var4.delete();
         }

         var3.renameTo(var4);
      } catch (Exception var5) {
         MinecraftServer.func_71276_C().func_98033_al().func_98236_b("Failed to save player data for " + p_75753_1_.func_70005_c_());
      }

   }

   public NBTTagCompound func_75752_b(EntityPlayer p_75752_1_) {
      NBTTagCompound var2 = this.func_75764_a(p_75752_1_.func_70005_c_());
      if(var2 != null) {
         p_75752_1_.func_70020_e(var2);
      }

      return var2;
   }

   public NBTTagCompound func_75764_a(String p_75764_1_) {
      try {
         File var2 = new File(this.field_75771_c, p_75764_1_ + ".dat");
         if(var2.exists()) {
            return CompressedStreamTools.func_74796_a(new FileInputStream(var2));
         }
      } catch (Exception var3) {
         MinecraftServer.func_71276_C().func_98033_al().func_98236_b("Failed to load player data for " + p_75764_1_);
      }

      return null;
   }

   public IPlayerFileData func_75756_e() {
      return this;
   }

   public String[] func_75754_f() {
      String[] var1 = this.field_75771_c.list();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         if(var1[var2].endsWith(".dat")) {
            var1[var2] = var1[var2].substring(0, var1[var2].length() - 4);
         }
      }

      return var1;
   }

   public void func_75759_a() {}

   public File func_75758_b(String p_75758_1_) {
      return new File(this.field_75768_d, p_75758_1_ + ".dat");
   }

   public String func_75760_g() {
      return this.field_75767_f;
   }
}
