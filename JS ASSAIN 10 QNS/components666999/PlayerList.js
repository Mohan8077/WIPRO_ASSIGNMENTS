import React from "react";

function PlayerList({ players, onEdit, onDelete }) {
  return (
    <table className="table" border={1} cellPadding={5}>
      <thead>
        <tr>
          <th>Name</th>
          <th>Age</th>
          <th>Position</th>
          <th>Club</th>
          <th>Goals</th>
          <th>Matches Played</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        {players.length === 0 ? (
          <tr>
            <td colSpan="7" style={{ textAlign: "center" }}>
              No Players Found
            </td>
          </tr>
        ) : (
          players.map((player) => (
            <tr key={player.id}>
              <td>{player.name}</td>
              <td>{player.age}</td>
              <td>{player.position}</td>
              <td>{player.club}</td>
              <td>{player.goals}</td>
              <td>{player.matchesPlayed}</td>
              <td>
                <button onClick={() => onEdit(player)}>Edit</button>{" "}
                <button onClick={() => onDelete(player.id)}>Delete</button>
              </td>
            </tr>
          ))
        )}
      </tbody>
    </table>
  );
}

export default PlayerList;
