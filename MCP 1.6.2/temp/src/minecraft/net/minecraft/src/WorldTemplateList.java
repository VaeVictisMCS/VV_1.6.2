package net.minecraft.src;

import argo.jdom.JdomParser;
import argo.jdom.JsonNode;
import argo.jdom.JsonRootNode;
import argo.saj.InvalidSyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.src.ValueObject;
import net.minecraft.src.WorldTemplate;

public class WorldTemplateList extends ValueObject {

   public List field_110736_a;


   public static WorldTemplateList func_110735_a(String p_110735_0_) {
      WorldTemplateList var1 = new WorldTemplateList();
      var1.field_110736_a = new ArrayList();

      try {
         JsonRootNode var2 = (new JdomParser()).parse(p_110735_0_);
         if(var2.isArrayNode(new Object[]{"templates"})) {
            Iterator var3 = var2.getArrayNode(new Object[]{"templates"}).iterator();

            while(var3.hasNext()) {
               JsonNode var4 = (JsonNode)var3.next();
               var1.field_110736_a.add(WorldTemplate.func_110730_a(var4));
            }
         }
      } catch (InvalidSyntaxException var5) {
         ;
      } catch (IllegalArgumentException var6) {
         ;
      }

      return var1;
   }
}
