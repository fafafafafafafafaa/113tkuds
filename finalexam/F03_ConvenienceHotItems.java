import java.util.Scanner;

public class F03_ConvenienceHotItems {
   public F03_ConvenienceHotItems() {
   }

   public static void main(String[] var0) {
      Scanner var1 = new Scanner(System.in);
      int var2 = Integer.parseInt(var1.nextLine());  // 輸入商品數量 n
      F03_ConvenienceHotItems$Item[] var3 = new F03_ConvenienceHotItems$Item[var2];

      // 讀入商品資料，時間複雜度 O(n)，空間 O(n)
      for(int var4 = 0; var4 < var2; ++var4) {
         String[] var5 = var1.nextLine().split(" ");
         var3[var4] = new F03_ConvenienceHotItems$Item(var5[0], Integer.parseInt(var5[1]));
      }

      // 插入排序：排序商品陣列依 qty 降冪
      // 時間複雜度 O(n^2) 最壞與平均
      // 空間複雜度 O(1) (原地排序)
      for(int var4 = 1; var4 < var2; ++var4) {
         F03_ConvenienceHotItems$Item var7 = var3[var4];

         int var6;
         // 將 var7 插入前面排序好的區間中
         for(var6 = var4 - 1; var6 >= 0 && var3[var6].qty < var7.qty; --var6) {
            var3[var6 + 1] = var3[var6]; // 元素右移
         }

         var3[var6 + 1] = var7;
      }

      // 輸出前10筆商品（或不足10筆）
      // 時間複雜度 O(1)，因輸出數量固定
      for(int var4 = 0; var4 < Math.min(10, var2); ++var4) {
         System.out.println(var3[var4].name + " " + var3[var4].qty);
      }

      var1.close();
   }

   // 內部類別：商品項目，空間 O(n)
   static class F03_ConvenienceHotItems$Item {
       String name;
       int qty;

       public F03_ConvenienceHotItems$Item(String name, int qty) {
           this.name = name;
           this.qty = qty;
       }
   }
}

