package me.eladiofeijoo.bootcampers.models;

import java.util.UUID;

public class Bootcamper {
    private UUID id;
    private String name;

    public Bootcamper() {}
    public Bootcamper(String name) { this.id = UUID.randomUUID(); this.name = name; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public UUID getId() { return id; }

}
