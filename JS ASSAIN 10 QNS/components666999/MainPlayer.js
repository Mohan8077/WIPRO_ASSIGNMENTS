import React, { useState, useEffect } from "react";
import axios from "axios";
import PlayerForm from "./PlayerForm";
import PlayerList from "./PlayerList";

function MainPlayer() {
  const emptyPlayer = {
    name: "",
    age: "",
    position: "",
    club: "",
    nationality: "",
    goals: 0,
    matchesPlayed: 0,
    jerseyNumber: 1,
    email: "",
    contactNumber: ""
  };

  const [selectedPlayer, setSelectedPlayer] = useState(null);
  const [players, setPlayers] = useState([]);
  const [formKey, setFormKey] = useState(0);

  const fetchPlayers = async () => {
    try {
      const res = await axios.get("http://localhost:5000/players");
      setPlayers(res.data);
    } catch (error) {
      console.error("Error fetching players:", error);
    }
  };

  useEffect(() => {
    fetchPlayers();
  }, []);

  const handleEdit = (player) => {
    setSelectedPlayer(player);
  };

  const handleSubmit = async (values, { setSubmitting, resetForm }) => {
    try {
      if (selectedPlayer && selectedPlayer.id) {
        await axios.put(`http://localhost:5000/players/${selectedPlayer.id}`, values);
      } else {
        await axios.post("http://localhost:5000/players", values);
      }
      setSelectedPlayer(null);
      setFormKey(formKey + 1); // reset form
      fetchPlayers();
      resetForm();
    } catch (error) {
      console.error("Error saving player:", error);
    }
    setSubmitting(false);
  };

  const handleDelete = async (id) => {
    try {
      await axios.delete(`http://localhost:5000/players/${id}`);
      fetchPlayers();
    } catch (error) {
      console.error("Error deleting player:", error);
    }
  };

  return (
    <div className="container mt-4">
      <h2>Football Player Management System</h2>
      <PlayerForm
        key={formKey}
        initialValues={selectedPlayer || emptyPlayer}
        onSubmit={handleSubmit}
      />
      <PlayerList players={players} onEdit={handleEdit} onDelete={handleDelete} />
    </div>
  );
}

export default MainPlayer;
