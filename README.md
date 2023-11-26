## LDTS_<03><07> - <Space_Shooter>

In this game it will be possible to control a spaceship in order to avoid objects that can cause damage to the ship, namely meteors and eliminate enemy ships, each with a certain amount of life and attack damage of its own. To combat them, our ship will be able to obtain certain power-ups over the course of the game, which can range from a temporary (or permanent) increase in attack damage, number of weapons and life, and increased movement speed.
The objective of the game is to get the highest score possible by destroying enemy ships with the help of power-ups, ending when our ship's health reaches zero.
This project was developed by Miguel Guerrinha (up202205038@fe.up.pt), Rui Cruz (up202208011@fe.up.pt) and Sheila Albino (up202109258@fe.up.pt).


## IMPLEMENTED FEATURES

- **Spaceship moves** - The spaceship moves to the left, right, up and down using the respectively arrows.
- **Meteors falling** - During the game, we have some meteors falling down the screen.
- **Hit by a meteor** - If the spaceship has a collision with a meteor the game stops.
- **Spawn and catch power-ups** - When the game starts, a certain number of power-ups appear in the screen and we are able to catch them with our spaceship.


## PLANNED FEATURES

- **Implement a menu** - The game will have the initial menu.
- **Enemies spaceships** - The game will have some enemies that are other spaceships.
- **Shots from enemies spaceships** - The enemies spaceships will have guns capable to fire projectile.
- **Enemies projectiles can kill our spaceship** - If a projectile from an enemy spaceship hit our spaceship we lost.
- **Spawning power-ups** - If we kill a special enemy spaceship it will drop a power-up that will fall down and if we can catch it, it will upgrade our spaceship.
- **Shots from our spaceship** - Our spaceship have guns capable to fire projectiles able to destroy enemies spaceships.
- **Health of spaceships** - Every spaceship have a certain quantity of health and when that health is zero the spaceship is destroyed.
- **Power of shots** - During the game by catching power-ups the projectiles from our spaceship will have more power.
- **Score** - Every time we hit an enemy spaceship our score increase.


## SCREENSHOTS

- **Menu Preview** - Temporary menu that will still undergo several design and implementation changes. So far it's possible to start and exit the game.
<p align="center">
  <img src="./resources/Images/menu.png" alt="Menu">
</p>

- **Arena Preview** - Like the menu, this arena is the basis of what we intend to implement in the future, the appearance of the elements will be changed, improving the visual aspect of the game and some missing elements will be added later, namely enemy spaceships.
<p align="center">
  <img src="./resources/Images/arena.png" alt="Menu">
</p>


## DESIGN

### Structure

#### Problem in Context
The problem lies in the lack of a clear and well-defined structure to separate the game's business logic, visual presentation, and interaction control. This results in complexity, maintenance difficulties, low code reusability, and potential conflicts among different parts of the game. The **MVC pattern** is a solution that addresses these challenges by dividing the game into three distinct components (Model, View, and Controller) to provide an organized and modular structure.

#### The Pattern
This pattern allows for a clear separation of concerns, making it easier to maintain code, scale the application, and reuse components. In addition, it facilitates collaboration between development teams, as each component has a clearly defined responsibility.

#### Implementation
For MVC Pattern implementation, the **Model**: Refactors existing classes to represent the game's business logic (such as Arena, Element, Game),
**View**: These are the Classes related to the graphical interface (TextGraphics, on-screen drawing methods).
and **Controller**: Manages user interaction (Arena.processKey(), input control methods).

<p align="center">
  <img src="./resources/Images/uml.png" alt="UML">
</p>

#### Consequences
- **Structured Organization**: Clear division of system responsibilities.
- **Ease of Maintenance**: Changes to one layer do not directly affect the others.


### State Pattern

#### Problem in Context

In the game, different states need to be managed, such as Running, Paused, and GameOver. Each state has specific key processing logic and on-screen drawings.

#### The Pattern

We have applied the ***State*** pattern. This pattern helps you in State Management, i.e. encapsulating the specific behavior of each game state in separate classes (RunningState, PausedState, GameOverState). and Extension facility that allows the addition of new states without modifying existing classes.

#### Implementation

Regarding implementation, the State Pattern creates a GameState or State interface with processKey() and draw() methods to represent behaviors common to all states and also implements classes (RunningState, PausedState, GameOverState) that inherit or implement the GameState interface with specific logic. of each state.
<p align="center">
  <img src="./resources/Images/state_pattern.png" alt="State Pattern">
</p>

#### Consequences

The use of the State Pattern in the current design allows the following benefits:
- **Maintainability**: Ease of adding, removing, or modifying states.
- **Readability**: Clarity in separating the logic of each game state.

### Factory Pattern

#### Problem in Context
In this game, there will be two types of controllers: the **Game Controller**, which manages the movement of each element in the game (spaceships, meteors, etc.) and the **Menu Controller**, which allows you to move around the Menu, i.e. whether you want to leave or enter the game.

#### The Pattern

With this problem in mind, we opted for the **Factory Pattern**, which allows objects to be created without specifying the exact class of the object to be created, and Creation Encapsulation, i.e. delegating responsibility for creation to subclasses. This way we can create more than one type of controller.

#### Implementation

As for implementation, factory creates a common Element interface or abstract class for all game elements,
implements an ElementFactory class with methods (e.g., createMeteor(), createPower(), createSpaceShip()) to create each element type and ElementFactory subclasses for each element type that implement the creation methods.
<p align="center">
  <img src="./resources/Images/factory_pattern.png" alt="Factory Pattern">
</p>

#### Consequences

- **Flexibility**: Makes it easy to add new types of elements.
- **Decoupling**: Separates the object's creation logic from its specific implementations.


### TESTING
We were able to successfully carry out 4 tests:

- The **SpaceShipControllerTest**, which tests the movement of our spaceship because if it doesn't work properly, we won't be able to defeat the enemies that will appear in the future.
- The **InterfaceTest**, which tests whether the spaceship and text are drawn correctly.
- The **PositionTest**, allows to check that the moves of the elements work well.
- The **ArenaViewerTest**, tests whether the arena's setSpaceShip function is implemented correctly, as well as the Clear and Refresh functions relating to the GUI interface.
- The **SpaceShipViewerTest**, which tests whether the spaceship is well designed.


<p align="center">
  <img src="./resources/Images/all_tests.png" alt="Tests">
</p>


- **Screenshot of coverage report** - class coverage: 47%, method coverage: 42%, line coverage 29%
<p align="center">
  <img src="./resources/Images/tests_coverage.png" alt="Tests_Coverage">
</p>


### SELF-EVALUATION

- Miguel Guerrinha: 33,33%
- Rui Cruz: 33,33%
- Sheila Albino: 33,33%
  