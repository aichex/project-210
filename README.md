# BucketList Organizer and Planner 

## Proposal: 

### *What will the application do?*

This application will serve as a **Bucket List** organizer and planner. The application will allow users to create  
*to-do* categories.  
eg. "Restaurants to Eat" or "Places to go."  
Users can create an entry into the Bucket list. An entry will allow the user the following functions:  
* Set Date or Date Estimate 
* Set Cost
* Description entry - Can serve as a journal entry.  

Upon completion of entry, users return to a list of **Bucket List** categories, upon clicking into each category  
users will see all *to-do* entries. 
Users can label each entry:   
* Mark *to-do* as "Completed"
 * Marking a *to-do* as completed will move entry to **Completed** category.  
* Mark *to-do* as "Pending" 

-- 

### *Who will use this application?*  

This application is designed for individuals who like to map out certain life goals.  
With the understanding that many couples may use this application to plan out collective *to-do* tasks, this  
application serves to create a user-friendly and simple-to-use interface that allows users to quickly  
create, organized and plan out vacations, date ideas and life goals etc.  

### *Why is this Project of Interest to you?* 

My girlfriend and I always discuss things we want to do together in the future. This often includes  
local restaurants, travel destinations and experiences we want to experience together. However, these  
ideas never get written down and slowly but surely, they fade out of our memories. I hope that with this application,  
I will be able to keep track of all the things we want to do together and plan out each and every one with her. 

## Phase 1: 

### User Stories Implemented:  
1. User Story: Add a ToDo Item into list and set a date in format "MM/DD/YY"
CONSTRAINT: Only one string can be taken for the name. 
2. User Story: Delete a ToDo Item from current ToDo list by name 
3. User Story: Show all ToDo Items in current ToDo list 
4. User Story: Mark a current ToDo Item as Completed, which moves item to Completed ToDo List
5. User Story: Show all ToDo Items in completed ToDo List 

## Phase 2: 

### User Stories Implemented: 
6. User Story: To add a ToDo Item, must select Category  
7. User Story: Show ToDO Items in selected Category 
8. User Story: Show all Categories in Inventory
9. User Story: Save Completed To-Do list on file 
10. User Story: Load Completed To-Do list from file 

##Phase 3: 

###User Stories Implemented in GUI: 
1. User Story: Add a Category into Inventory with a textField and Button
2. User Story: Add a ToDo Item into Completede Category with textField and Button 

##Phase 4:

###Phase 4: Task 2 

Included a Type Hierarchy in Code:  
* Abstract Classes: Tool and TextField  
* SubClasses for Tool: AddToDoTool and AddCategoryTool  
* Methods Override: createButton, addListener
* SubClasses for TextField: CategoryNameTool and ToDoNameTool 
* Methods Override: addListener 

