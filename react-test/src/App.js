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

  function reset(){
    setCard1([]);
    setCard2([]);
  }

  var [player1, setCard1] = useState([]);
  var [player2, setCard2] = useState([]);
  var [battelResult, setbr] = useState("");

  const totalAtP1 = player1.reduce((ac, cd) => ac + cd.attack, 0);
  const totalAtP2 = player2.reduce((ac, cd) => ac + cd.attack, 0);
  const totalDfP1 = player1.reduce((ac, cd) => ac + cd.defense, 0);
  const totalDfP2 = player2.reduce((ac, cd) => ac + cd.defense, 0);

  function battle(){
    var p1Score = totalAtP1-totalDfP2;
    var p2Score = totalAtP2-totalDfP1;
    var result = "";
    var s = 0;
    if(p1Score>p2Score){
      s = p1Score - p2Score;
      result = s+" 파워 차이로 플레이어1 승리!"
    }else if(p2Score>p1Score){
      s = p2Score - p1Score;
      result = s+" 파워 차이로 플레이어2 승리!"
    }else{
      result = "무승부!"
    }

    setbr(result);
  }

  return (
    <>
      <h2>플레이어1</h2>
      <button onClick={gachaApi1}>카드뽑기</button>
      <CardArea>
        {player1.map((cd, index) => (
          <Card key={index} pokemon={cd.pokemon} grade={cd.grade} at={cd.attack} df={cd.defense} />
        ))}
      </CardArea>
        총 공격력 : {totalAtP1}<br></br>
        총 방어력 : {totalDfP1}<br></br>
      <h2>플레이어2</h2>
      <button onClick={gachaApi2}>카드뽑기</button>
      <CardArea>
        {player2.map((cd, index) => (
          <Card key={index} pokemon={cd.pokemon} grade={cd.grade} at={cd.attack} df={cd.defense} />
        ))}
      </CardArea>
        총 공격력 : {totalAtP2}<br></br>
        총 방어력 : {totalDfP2}
        <hr></hr>
        <button onClick={battle}>배틀</button><br></br>
        배틀 결과 : {battelResult}
        <hr></hr>
        <button onClick={reset}>게임리셋</button><br></br>
    </>
  )
}

export default App;