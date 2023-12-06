/**
 * The {@code Plane} class represents an aircraft with properties such as model, maximum speed, flying status,
 * fuel capacity, current fuel level, and registration code.
 */
public class Plane {
    private String model;
    private double maxSpeed;
    private boolean isFlying;
    private double fuelCapacity;
    private double currentFuelLevel;
    private String registrationCode;

    /**
     * Constructs a new {@code Plane} object with the specified model, registration code, maximum speed, and fuel capacity.
     * @param model            The model of the plane.
     * @param registrationCode The registration code of the plane.
     * @param maxSpeed         The maximum speed of the plane.
     * @param fuelCapacity     The fuel capacity of the plane.
     */
    public Plane(String model, String registrationCode, double maxSpeed, double fuelCapacity) {
        this.model = model;
        this.registrationCode = registrationCode;
        this.maxSpeed = maxSpeed;
        this.isFlying = false;
        this.fuelCapacity = fuelCapacity;
        this.currentFuelLevel = 0.0;
    }

    // Getters and setters
    
    /**
     * Gets the model of the plane.
     * @return The model of the plane.
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the model of the plane.
     * @param model The new model of the plane.
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gets the maximum speed of the plane.
     * @return The maximum speed of the plane.
     */
    public double getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * Sets the maximum speed of the plane.
     * @param maxSpeed The new maximum speed of the plane.
     */
    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    /**
     * Checks if the plane is currently flying.
     * @return {@code true} if the plane is flying, {@code false} otherwise.
     */
    public boolean isFlying() {
        return isFlying;
    }

    /**
     * Sets the flying status of the plane.
     * @param flying {@code true} to set the plane as flying, {@code false} to set it as not flying.
     */
    public void setFlying(boolean flying) {
        isFlying = flying;
    }

    /**
     * Gets the fuel capacity of the plane.
     * @return The fuel capacity of the plane.
     */
    public double getFuelCapacity() {
        return fuelCapacity;
    }

    /**
     * Sets the fuel capacity of the plane.
     * @param fuelCapacity The new fuel capacity of the plane.
     */
    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    /**
     * Gets the current fuel level of the plane.
     * @return The current fuel level of the plane.
     */
    public double getCurrentFuelLevel() {
        return currentFuelLevel;
    }

    /**
     * Sets the current fuel level of the plane.
     * @param currentFuelLevel The new current fuel level of the plane.
     */
    public void setCurrentFuelLevel(double currentFuelLevel) {
        this.currentFuelLevel = currentFuelLevel;
    }

    /**
     * Gets the registration code of the plane.
     * @return The registration code of the plane.
     */
    public String getRegistrationCode() {
        return registrationCode;
    }

    /**
     * Sets the registration code of the plane.
     * @param registrationCode The new registration code of the plane.
     */
    public void setRegistrationCode(String registrationCode) {
        this.registrationCode = registrationCode;
    }

    /**
     * Prints information about the plane, including model, maximum speed, flying status,
     * fuel capacity, current fuel level, and registration code.
     */
    public void print() {
        System.err.println("--------------------");
        System.out.println("Model: " + this.model);
        System.out.println("Maximum Speed: " + this.maxSpeed);
        System.out.print("Currently flying: ");
        System.out.println(this.isFlying ? "yes" : "no");
        System.out.println("Fuel Capacity: " + this.fuelCapacity);
        System.out.println("Current fuel level: " + this.currentFuelLevel);
        System.out.println("Registration Code: " + this.registrationCode);
    }
}
