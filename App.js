import React from 'react';
import GroceryList from './components/GroseryList';
import Car from './components/Car';
import Phone from './components/Phone';
import SweetsList from './components/SweetsList';
import Electronics from './components/Electronics';
import CanteenMenu from './components/CanteenMenu';
import JuiceList from './components/JuiceList';
import Restaurant from './components/Restaurant';
import TempleList from './components/TempleList';
import TailorShop from './components/TailorShop';
import './App.css';  // instead of './styles/App.css'




const groceries = ["Rice", "Wheat", "Sugar", "Milk", "Oil"];

function App() {
  return (
    <div className="App">
      <GroceryList items={groceries} />
      <Car brand="Toyota" model="Fortuner" color="Black" year="2022" />
      <Phone />
      <SweetsList />
      <Electronics />
      <CanteenMenu />
      <JuiceList />
      <Restaurant />
      <TempleList />
      <TailorShop />
    </div>
  );
}

export default App;
