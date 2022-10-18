class A{
   public static void main(String[] args){
      int b = Integer.parseInt(args[0]);
      for(int a=0; a<b; a++){
         for(int c=0; c<a; c++){
            System.out.print(" ");
         }
         for(int c=0; c<(b-(a+1))*2; c++){
            System.out.print("*");         
         }
      System.out.println("*");
      }

   }
}
