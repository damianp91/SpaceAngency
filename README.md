# 🌐 Idioma / Language  
> 📌 **Select your language:**  
> - [Español](README.es.md)  
> - [**English**](README.md) (current)  
---

# SpaceAgency

## Space Expedition Management System

### General Context
The Space Agency manages a fleet of spacecraft participating in various interplanetary missions. Each spacecraft has common characteristics but also specific attributes depending on its type. The agency manages the following types of spacecraft:

- 🛰 Exploration Ships: Perform missions of type CARTOGRAPHY, RESEARCH, or CONTACT.
- 🚚 Cargo Ships: Transport supplies with a cargo capacity between 100 and 500 tons.
- 🚀 Star Cruisers: Transport passengers through deep space.

### System Requirements
All spacecraft have:
- name (String)
- crew capacity (int)
- launch year (int)

### Subclasses have additional attributes

| Spacecraft Type   | Specific Attributes                            |
|-------------------|------------------------------------------------|
| Exploration       | missionType: CARTOGRAPHY; RESEARCH; CONTACT    |
| Cargo Ship        | cargoCapacity: between 100 and 500 tons        |
| Star Cruiser      | passengerCount (int)                           |

### Common Behaviors:
- showShips(): displays all ships with their data.
- addShip(Ship ship): adds a ship if one with the same name and year doesn't already exist
- startExploration(): Starts the mission for explorable ships (Exploration and Cargo Ships). 
  Star Cruisers don't participate and a console message is displayed.

### Comparison Methods:
- Two ships are considered equal if they have the same name and launch year.
- ```java Comparable<Ship>``` is implemented to sort by:
- Launch year (newest first)
- Crew capacity (highest to lowest)

### Console Menu Functionalities
1. Add ship (Exploration, Cargo, or Star Cruiser)
2. Show all registered ships
3. Start exploration mission
4. Show ships sorted by name (Comparable)
5. Show ships sorted by launch year (descending)
6. Show ships sorted by crew capacity (descending)
7. Exit System

### Validations
- Cargo capacity validation (100 to 500) is performed before instantiating the cargo ship object. If a value less than 100 is entered, it's set to 100, and similarly for the upper limit.
- The system doesn't use exceptions for flow control, but rather preliminary validations and user-friendly messages.
- The use of equals() allows clear and reusable duplicate validation.

> [!TIP]
> Execution Example
```console
=== SPACE EXPEDITION MANAGEMENT MENU ===
1. Add ship  
2. Show all ships  
3. Start exploration  
4. Show ships sorted by name  
5. Show ships sorted by launch year (desc)  
6. Show ships sorted by crew capacity (desc)  
7. Exit  

Select an option: 1  
--- Ship Type ---  
1. Exploration ship  
2. Cargo ship  
3. Star cruiser  

Select ship type: 2  
Name: GalaxyCargo  

Crew capacity: 8  
Launch year: 2047  

Cargo capacity (100 to 500): 450  
Ship added successfully.
```

### Based on the previous prompt, the following is requested:
1. Create the complete class diagram using umletino, showing the relationship  
   between Nave, NaveExploracion, Carguero, CruceroEstelar, and others.  
2. Implement the Java source code to fulfill the requested functionalities.

### Additional details:

* Class Diagram:
    - It must correctly reflect the class hierarchy among the spacecraft.
    - Common attributes should be in the base class Nave and specific ones in the derived classes.

* Classes and Inheritance:
    - There must be an abstract class Nave containing the common attributes:  
      name, crew capacity, and launch year.
    - Three classes should inherit from Nave: NaveExploracion, Carguero, and CruceroEstelar.
    - Exploration ships must have the attribute missionType (with values:  
      CARTOGRAPHY, RESEARCH, CONTACT), cargo ships must have the attribute  
      cargoCapacity (in tons), and star cruisers the attribute passengerCount.

* Methods:
    - The agregarNave() method must add ships to a collection and throw an exception if the  
      ship already exists.
    - The mostrarNaves() method must print a list of all ships and their attributes.
    - The iniciarExploracion() method must allow exploration to begin for exploration ships  
      and cargo ships, and report that star cruisers cannot participate in missions.
    - Develop all necessary methods to ensure functionality.

### Example scenarios:
1. Adding spacecraft:
    - It should be possible to add a cargo ship named "Galáctica" with a cargo capacity of  
      300 tons, and when trying to add another ship with the same name and launch year,  
      a warning should be triggered.
2. Displaying ships:
    - The system should be able to list all ships, showing both common attributes  
      (name, crew capacity, launch year) and specific ones (mission type, cargo capacity, or passenger count).
3. Starting exploration:
    - The system should allow exploration ships and cargo ships to start their mission,  
      while indicating that star cruisers cannot participate.

-------

## Test Data Table for the Space Agency
| Ship Type            | Name             | Crew Capacity     | Launch Year       | Specific Attribute                       |
|----------------------|------------------|-------------------|-------------------|-------------------------------------------|
| Exploration Ship      | Odisea           | 10                | 2050              | Mission: RESEARCH                         |
| Exploration Ship      | CosmosX          | 7                 | 2042              | Mission: CARTOGRAPHY                      |
| Exploration Ship      | Alfa Centauri    | 6                 | 2035              | Mission: CONTACT                          |
| Cargo Ship            | CargaGalaxia     | 5                 | 2047              | Cargo Capacity: 450 tons                  |
| Cargo Ship            | VulcanoCargo     | 8                 | 2049              | Cargo Capacity: 300 tons                  |
| Cargo Ship            | MercurioX        | 4                 | 2045              | Cargo Capacity: 120 tons                  |
| Star Cruiser          | EstelarLux       | 15                | 2045              | Passengers: 1000                          |
| Star Cruiser          | NebulaStar       | 20                | 2048              | Passengers: 1500                          |
| Star Cruiser          | AuroraEspacial   | 12                | 2038              | Passengers: 750                           |

-------

## Functional Test Scenarios
| Nº | Scenario                              | Input / Action                                    | Expected Result                                                                 |
|----|----------------------------------------|---------------------------------------------------|----------------------------------------------------------------------------------|
| 1  | Add valid exploration ship             | Name: Odisea, Year: 2050, Mission: RESEARCH       | Ship added successfully                                                          |
| 2  | Add valid cargo ship                   | Name: CargaGalaxia, Cargo: 400 tons               | Ship added successfully                                                          |
| 3  | Add star cruiser                       | Name: EstelarLux, Passengers: 1200                | Ship added successfully                                                          |
| 4  | Add cargo ship with out-of-range cargo | Cargo: 90 tons                                    | Rejection with message: "Value out of range. Try again."                         |
| 5  | Add duplicate ship                     | Name: Odisea, Year: 2050 (already exists)         | Rejection with message: "A ship with that name and launch year already exists." |
| 6  | Show all ships                         | Action: menu option 2                             | List of ships in order of entry                                                  |
| 7  | Start exploration                      | Action: option 3                                  | Runs explorar() method for explorers and cargo ships. Notifies for cruisers.    |
| 8  | Sort by name (Comparable)              | Action: option 4                                  | List sorted alphabetically by name                                               |
| 9  | Sort by launch year (Comparator)       | Action: option 5                                  | List sorted from most recent to oldest                                           |
| 10 | Sort by crew capacity (Comparator)     | Action: option 6                                  | List sorted with highest crew capacity first                                     |

-------

## Validation and Error Handling Scenarios
| Nº | Scenario                           | Input / Action                | Expected Result                             |
|:--:|:----------------------------------:|:-----------------------------:|:--------------------------------------------:|
| 11 | Load ship with negative year       | Launch year: -2030            | Rejection or validation message              |
| 12 | Load ship with empty name          | Name: [Enter]                 | Rejection or prompt to re-enter              |
| 13 | Load cargo ship without validating | Cargo: 1000                   | Adjust or show warning                       |
| 14 | Enter invalid ship type            | Type: 99                      | "Invalid type" in console                    |
| 15 | Enter text where number expected   | Capacity: abc                 | Re-entry message: "Enter a valid number"     |
"""
