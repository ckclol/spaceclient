package client.mod;

public abstract class Mod {
   private String name;
   private boolean eord;
   private double version;
   private int prior;
   public Mod(String name, boolean eord, double version, int prior) {
   this.name = name;
   this.eord = eord;
   this.version = version;
   this.prior = prior;
   }
   public int getPrior() {
      return this.prior;
      }
   public double getVersion() {
      return this.version;
      }
   public boolean getEord() {
      return this.eord;
      }
   public String getName() {
      return this.name;
      }
}
