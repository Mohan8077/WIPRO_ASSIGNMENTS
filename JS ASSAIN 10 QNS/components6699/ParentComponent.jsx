// Import React and useState hook from the React library
import React, { useState } from 'react';

/*
  ChildA Component
  ----------------
  This component receives:
    - `fruits` (an array of fruit names) from the parent
    - `onSelectFruit` (a function to notify parent when a fruit is selected)

  It displays a list of fruits. When a fruit is clicked, it tells the parent.
*/
const ChildA = ({ fruits, onSelectFruit }) => {
  return (
    <div>
      <h4>Fruit List</h4>
      <ul>
        {/* Loop through each fruit and display it */}
        {fruits.map((fruit, index) => (
          <li
            key={index} // unique key for each item (React needs this)
            style={{ cursor: 'pointer' }} // make it clickable
            onClick={() => onSelectFruit(fruit)} // when clicked, send selected fruit to parent
          >
            {fruit}
          </li>
        ))}
      </ul>
    </div>
  );
};

/*
  ChildB Component
  ----------------
  This component receives:
    - `onSendFruit` (a function from the parent)

  When the button is clicked, it calls the parent function
  to add "Orange" to the list.
*/
const ChildB = ({ onSendFruit }) => {
  return (
    <div>
      <h4>Sender</h4>
      {/* When clicked, this will add "Orange" to the parent's fruit list */}
      <button onClick={() => onSendFruit('Orange')}>Send Fruit</button>
    </div>
  );
};

/*
  ChildC Component
  ----------------
  This component receives:
    - `selectedFruit` (the fruit selected in ChildA)

  It simply displays the selected fruit.
*/
const ChildC = ({ selectedFruit }) => {
  return (
    <div>
      <h4>Selected Fruit</h4>
      {/* Show the selected fruit (coming from parent state) */}
      <p>{selectedFruit}</p>
    </div>
  );
};

/*
  ParentComponent
  ----------------
  This is the main (parent) component.
  It:
    - holds the list of fruits
    - keeps track of the selected fruit
    - passes data and functions to children to allow communication

  Children:
    - ChildA (shows list and selects fruit)
    - ChildB (adds new fruit to list)
    - ChildC (displays selected fruit)
*/
const ParentComponent = () => {
  // State to hold the list of fruits
  const [fruits, setFruits] = useState(['Apple']);

  // State to hold the selected fruit
  const [selectedFruit, setSelectedFruit] = useState('');

  // Function to add a new fruit to the list
  const addFruit = (newFruit) => {
    // Add the new fruit to the existing list
    setFruits((prevFruits) => [...prevFruits, newFruit]);
  };

  // Function to handle when a fruit is selected in ChildA
  const handleSelectFruit = (fruit) => {
    // Update the selected fruit state
    setSelectedFruit(fruit);
  };

  // Return the UI
  return (
    <div style={{ textAlign: 'center' }}>
      <h3>React – Parent / Child / Sibling Communication</h3>

      {/* Arrange the 3 children in a row with spacing */}
      <div style={{ display: 'flex', justifyContent: 'center', gap: '40px' }}>
        {/* Pass fruit list and selection handler to ChildA */}
        <ChildA fruits={fruits} onSelectFruit={handleSelectFruit} />

        {/* Pass the function to add a new fruit to ChildB */}
        <ChildB onSendFruit={addFruit} />

        {/* Pass the selected fruit to ChildC */}
        <ChildC selectedFruit={selectedFruit} />
      </div>
    </div>
  );
};

// Export the component so it can be used in App.js
export default ParentComponent;
