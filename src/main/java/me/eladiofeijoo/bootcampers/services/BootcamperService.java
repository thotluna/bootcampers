package me.eladiofeijoo.bootcampers.services;

import me.eladiofeijoo.bootcampers.models.Bootcamper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BootcamperService {
    private List<Bootcamper> bootcampers = new ArrayList();

    public void create(String name){
        UUID id = UUID.randomUUID();
        bootcampers.add(new Bootcamper(name));
    }

    public List<Bootcamper> getAll(){

        return bootcampers;
    }

    public Bootcamper get(String name){
        for(Bootcamper bootcamper : bootcampers){
            if(bootcamper.getName().equalsIgnoreCase(name)){
                return bootcamper;
            }
        }
        return null;
    }

    public Bootcamper get(UUID id){
        for(Bootcamper bootcamper : bootcampers){
            if(bootcamper.getId() == id){
                return bootcamper;
            }
        }
        return null;
    }

    public void delete(String name){
        for(Bootcamper bootcamper : bootcampers){
            if(bootcamper.getName().equalsIgnoreCase(name)){
                bootcampers.remove(bootcamper);
            }
        }
    }


}
