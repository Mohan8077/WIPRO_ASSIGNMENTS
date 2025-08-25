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

import Fruits from './components69/Fruits';
import TelevisionManager from './components69/TelevisionManager';
import MarriageForm from './components69/MarriageForm';
import AccessoriesForm from './components69/AccessoriesForm';
import BakingItemsForm from './components69/BakingItemsForm';
import FlightBookingForms from './components69/FlightBookingForms';
import MovieForm from './components69/MovieForm';

import ErrorComponent from './components6699/ErrorComponent';
import LoadingComponent from './components6699/LoadingComponent';
import ProductComponent from './components6699/ProductComponent';
import MainComponent from './components6699/MainComponent';
import FurnitureStore from './components6699/FurnitureStore';
import FestivalApp from './components6699/FestivalApp';
import RestaurantRegistration from './components6699/RestaurantRegistration';
import ParentComponent from './components6699/ParentComponent';

import ChessTournamentForm from './components666999/ChessTournamentForm';
import HockeyRegistrationForm from './components666999/HockeyRegistrationForm.jsx';
import Tailor from './components666999/Tailor.js';
import MainPlayer from './components666999/MainPlayer.js';
import SendAnnouncement from './components666999/SendAnnouncement';
import AnnouncementList from './components666999/AnnouncementList';
import IncomeTaxApp from './components666999/IncomeTaxApp';

import { PowerCutProvider } from './context/PowerCutContext';

import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';

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
      <Fruits />
      <TelevisionManager />
      <MarriageForm />
      <AccessoriesForm />
      <BakingItemsForm />
      <FlightBookingForms />
      <MovieForm />
      <ErrorComponent />
      <LoadingComponent />
      <ProductComponent />
      <MainComponent />
      <FurnitureStore />
      <FestivalApp />
      <RestaurantRegistration />
      <ParentComponent />
      <ChessTournamentForm />
      <HockeyRegistrationForm />
      <Tailor />
      <MainPlayer />

      {/* Power Cut Announcement System */}
      <PowerCutProvider>
        <div className="container mt-4">
          <h2 className="mb-4">Street Power Cut Announcements</h2>
          <SendAnnouncement />
          <AnnouncementList />
        </div>
      </PowerCutProvider>

      <IncomeTaxApp />
    </div>
  );
}

export default App;
