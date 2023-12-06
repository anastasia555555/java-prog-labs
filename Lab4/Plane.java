class Plane {
    private String model;
    private double maxSpeed;
    private boolean isFlying;
    private double fuelCapacity;
    private double currentFuelLevel;
    private String registrationCode;

    public Plane(String model, String registrationCode, double maxSpeed, double fuelCapacity) {
        this.model = model;
        this.registrationCode = registrationCode;
        this.maxSpeed = maxSpeed;
        this.isFlying = false;
        this.fuelCapacity = fuelCapacity;
        this.currentFuelLevel = 0.0;
    }

    // Getters and setters
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public boolean isFlying() {
        return isFlying;
    }

    public void setFlying(boolean flying) {
        isFlying = flying;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }
 
    public double getCurrentFuelLevel() {
        return currentFuelLevel;
    }

    public void setCurrentFuelLevel(double currentFuelLevel) {
        this.currentFuelLevel = currentFuelLevel;
    }

    public String getRegistrationCode() {
        return registrationCode;
    }

    public void setRegistrationCode(String registrationCode) {
        this.registrationCode = registrationCode;
    }

    public void print() {
        System.err.println("--------------------");
        System.out.println("Model: " + this.model);
        System.out.println("Maximum Speed: " + this.maxSpeed);
        System.out.print("Currently flying: ");
        System.out.println(this.isFlying ? "yes" : "no");
        System.out.println("Fuel Capacity: " + this.fuelCapacity);
        System.out.println("Current fuel level: " + this.currentFuelLevel);
        System.out.println("Regictration Code: " + this.registrationCode);
    }
}

