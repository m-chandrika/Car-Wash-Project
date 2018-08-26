package com.CarwashProject;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VehicleController {
	
@GetMapping("/vehicleEntry")
public String registrationForm(Model model) {
	model.addAttribute("vehicleEntry", new Vehicle());
	return "vehicleEntry";
}

@PostMapping("/vehicleEntry")
public String registrationSubmit(@Valid @ModelAttribute Vehicle vehicleEntry) {

	  String charges;
	  
	//check if the vehicle is stolen and if stolen, reject the service
	  if(vehicleEntry.getId()==1111111)
	  {
		  
		  System.out.println("the vehicle is stolen and does not get a car wash");
		  throw new IllegalArgumentException("Sorry, we cannot provide you service");
	  }
	  
	  // process the CarWash request
	  else
	  {	  
	  switch (vehicleEntry.getVtype()) {
	
      case "Car":
    	  
    	 // provide the bill for the Vehicle Type Car
    	 charges = "5$";
     	 vehicleEntry.setCharges(charges);  
     	 System.out.println("Charges for the car:"+charges);
    	 
          break;
          
      case "Truck":
    	  
    	  System.out.println("Hey Truck");	
    	  
    	  // Your car wash does not accept trucks with the bed let down.	  
    	  if(vehicleEntry.getBedStatus().equalsIgnoreCase("Yes")) {  
    		  System.out.println("Car Wash doesn't accept trucks with the bed let down");	
    		  throw new IllegalArgumentException("Sorry, we cannot provide you service, Car Wash doesn't accept trucks with the bed let down");
    	  }
     
    	  // if the Truck bed is not down, provide the service
    	  else 
    		  {
    		
    	 // if the Truck has mud, charge 2$ extra
    		if(vehicleEntry.getIsMud().equalsIgnoreCase("Yes")) 
    	    {
     		charges = "12$";
     		vehicleEntry.setCharges(charges);
     	    System.out.println("2$ extra for the truck with mud, so total charges: "+vehicleEntry.getCharges());			        		 
     	    }
    	  
    	// provide the regular bill for the Vehicle Type Truck
     	 else {
     		charges= "10$";
     		vehicleEntry.setCharges(charges);
     		System.out.println("Charges for your truck:  "+vehicleEntry.getCharges());
     	 }     	 
    	 
    	  }
    	  	  
          break;
          
      default:
          throw new IllegalArgumentException("Invalid type of Vehicle: " + vehicleEntry.getVtype());
      }
	  
    }
	
	return "result";
	}

}
