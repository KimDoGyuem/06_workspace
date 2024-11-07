import React, { useState } from 'react';
import './App.css';

var cards = ["카드1", "카드2", "카드3", "카드4", "카드5", "카드6", "카드7"];
var grade = ["S+", "S", "A", "B", "C", "D"];

function dice(n) {
  return Math.floor(Math.random() * n + 1);
}

function Card({ cards, grade }) {
  return (
    <div className={`card ${cards} ${grade}`}>
      {cards} - {grade}
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

  function gacha() {
    var c = cards[dice(6)];
    var g = grade[dice(5)];
    console.log(c, g);
    setMy([...my, { cards: c, grade: g }]);
  }

  var [my, setMy] = useState([]);

  return (
    <>
      <h2>플레이어1</h2>
      <button onClick={gacha}>카드뽑기</button>
      <CardArea>
        {my.map((cd, index) => (
          <Card key={index} cards={cd.cards} grade={cd.grade} />
        ))}
      </CardArea>

      <h2>플레이어2</h2>
      <button onClick={gacha}>카드뽑기</button>
      <CardArea>
        {my.map((cd, index) => (
          <Card key={index} cards={cd.cards} grade={cd.grade} />
        ))}
      </CardArea>
    </>
  )
}

export default App;