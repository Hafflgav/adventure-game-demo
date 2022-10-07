# Camunda Murder Mystery Game
> Code assets in this repository were part of a Camunda Platform 8 demo at CamundaCon 2022 in Berlin and are no longer maintained

In a horrible castle (not too far away from your home) there lived a horrible Duke with his horrible wife and their horrible servants. One morning the Duke was dead–murdered by one of the other horrible people living in the castle.
If you do not solve this murder mystery in time there will be another corpse - it might be even possible that it is yours. Make sure to solve the riddle and support the police!

## Starting up the game
1. Clone the repository
2. Update the **application.properties** files with your Camunda Platform 8 SaaS credentials (or link the workers to a local installation)
    - Adapt the properties in **game-init-worker**
    - and **c8-due-date-connector**
3. Spin up all (three) services

The BPMN models should be automatically being deployed to the engine on startup. If not you can find them in the **game-init-worker** resources folder. 

> **Note**: This project includes [Victor Franca's](https://github.com/francav) hey-duedate project. Updates are not propagated from the maintained project to here. 
> You should definitively check out the official [repository](https://github.com/francav/hey-duedate) if you are interested in due-date calculations across different time-zones. (I have only added the repository here to make the startup experience of the game smoother)

## Playing the Game
Of-course we want to play the game now. Therefore, we need to start an instance. You could either do so via the **Web-Modeler** or by leveraging the gRPC API.
Make sure to upload the BPMN file to the Web-Modeler if you want to start it from there.

Having started an instance you can open up **Tasklist** to work on the User Tasks and **Operate** in order to check on the lifecycle of the process instance. 

For sure this game is not feature complete but I hope you can enjoy it (or even submit some feature or pull requests)! 