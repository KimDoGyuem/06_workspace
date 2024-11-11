import axios from 'axios';
import React, { useState } from 'react';
import './App.css';

function Card({ pokemon, grade, at, df }) {
  return (
    <div className={`card ${pokemon} ${grade}`}>
      <div id="stats">
        {pokemon} - {grade} <br />
        공격력:{at} <br />
        방여력:{df}
      </div>
    </div>
  )
}

function CardArea({ children }) {
  return (
    <div id='card_area'>
      {children}
    </div>
  )
}

function App() {

  function gachaApi1() {
    axios.get('http://localhost:8080/spring/api/gacha')
      .then(response => {
        console.log(response.data);
        setCard1([...player1, response.data]);
      })
      .catch(error => {
        console.error('Error fetching data', error);
      });
  }
  function gachaApi2() {
    axios.get('http://localhost:8080/spring/api/gacha')
      .then(response => {
        console.log(response.data);
        setCard2([...player2, response.data]);
      })
      .catch(error => {
        console.error('Error fetching data', error);
      });
  }

  var [player1, setCard1] = useState([]);
  var [player2, setCard2] = useState([]);

  return (
    <>
      <h2>플레이어1</h2>
      <button onClick={gachaApi1}>카드뽑기</button>
      <CardArea>
        {player1.map((cd, index) => (
          <Card key={index} pokemon={cd.pokemon} grade={cd.grade} at={cd.attack} df={cd.defense} />
        ))}
      </CardArea>

      <h2>플레이어2</h2>
      <button onClick={gachaApi2}>카드뽑기</button>
      <CardArea>
        {player2.map((cd, index) => (
          <Card key={index} pokemon={cd.pokemon} grade={cd.grade} />
        ))}
      </CardArea>
    </>
  )
}

export default App;