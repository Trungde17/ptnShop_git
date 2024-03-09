/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author tinyl
 */
public class Specification {
    private String material;
    private String screen; 
    private String cpu;
    private String ram;
    private String hard_drive;
    private String graphics;
    private String os;
    private String weight;
    private String size;
    private String origin;
    private int launch_year;

    public Specification(String material, String screen, String cpu, String ram, String hard_drive, String graphics, String os, String weight, String size, String origin, int launch_year) {
        this.material = material;
        this.screen = screen;
        this.cpu = cpu;
        this.ram = ram;
        this.hard_drive = hard_drive;
        this.graphics = graphics;
        this.os = os;
        this.weight = weight;
        this.size = size;
        this.origin = origin;
        this.launch_year = launch_year;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getHard_drive() {
        return hard_drive;
    }

    public void setHard_drive(String hard_drive) {
        this.hard_drive = hard_drive;
    }

    public String getGraphics() {
        return graphics;
    }

    public void setGraphics(String graphics) {
        this.graphics = graphics;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getLaunch_year() {
        return launch_year;
    }

    public void setLaunch_year(int launch_year) {
        this.launch_year = launch_year;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Specification{" + "material=" + material + ", screen=" + screen + ", cpu=" + cpu + ", ram=" + ram + ", hard_drive=" + hard_drive + ", graphics=" + graphics + ", os=" + os + ", weight=" + weight + ", size=" + size + ", origin=" + origin + ", launch_year=" + launch_year + '}';
    }

   
}
