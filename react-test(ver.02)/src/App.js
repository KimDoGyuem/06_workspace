import axios from 'axios';
import React, { useState, useEffect, useCallback } from 'react';
import './App.css';

function Card({ pokemon, grade, at, df, adp }) {
  return (
    <div className={`card ${pokemon} ${grade}`} onClick={adp}>
      <div id="stats">
        {pokemon}-{grade} <br />
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
  
  const [player1, setMyCards] = useState([]);
  const [p1Party, setMyParty] = useState([]);
  const [ticket, setTicket] = useState([]);
  const [gold, setGold] = useState([]);

  
  const totalAtP1 = p1Party.reduce((ac, cd) => ac + cd.attack, 0);
  const totalDfP1 = p1Party.reduce((ac, cd) => ac + cd.defense, 0);
  
  useEffect(()=>{
    getMyCardApi();
    getMyPartyApi();
    getMyWealth();
  },[]);

  function gachaApi1() {
    axios.get('http://localhost:8080/spring/card/gacha')
      .then(response => {
        console.log(response.data);
        setMyCards([...player1, response.data]);
        getMyWealth();
      })
      .catch(error => {
        console.error('Error fetching data', error);
      });
  }

  var getMyCardApi = useCallback(()=>{
    axios.get('http://localhost:8080/spring/card/getMyCards')
    .then(response=>{
      setMyCards(response.data);
    })
    .catch(error=>{
      console.error('에러',error);
    })
  },[]);

  function adpc(index,no){
    if(p1Party.length >= 5){
      alert('파티는 최대 5명 까지임');
      return;
    }
    console.log(`보유카드 번호: ${index} 고유no+: ${no}`);
    var p = {id: 'red', no: no};
    // setMyParty([...p1Party,p]);
    partyAdd(p);
  }

  function partyAdd(p){
    axios.post('http://localhost:8080/spring/card/partyAdd',p)
    .then(response=>{
      console.log(response.data);
      getMyPartyApi();
      getMyCardApi();
    })
    .catch(error=>{
      console.error('에러',error);
    })
  }

  var getMyPartyApi = useCallback(()=>{
    axios.get('http://localhost:8080/spring/card/getMyParty?no=1')
    .then(response=>{
      setMyParty(response.data);
    })
    .catch(error=>{
      console.error('에러',error);
    })
  },[]);
  
  function clearCardListApi(){
    axios.get('http://localhost:8080/spring/card/clearCardList')			
    .then(response => {		
      console.log(response.data); 	
      getMyCardApi();
      getMyPartyApi();
    })		
    .catch(error => {		
      console.error('Error fetching data:', error);  // 에러 처리	
    });		
  }

  function clearPartyApi(){
    axios.get('http://localhost:8080/spring/card/clearParty')			
    .then(response => {		
      console.log(response.data); 	
      getMyCardApi();
      getMyPartyApi();
    })		
    .catch(error => {		
      console.error('Error fetching data:', error);  // 에러 처리	
    });		
  }
  
  var getMyWealth = useCallback(()=>{
    axios.get('http://localhost:8080/spring/shop/getWealth')
    .then(response=>{
      console.log(response.data);
      setGold(response.data.gold);
      setTicket(response.data.ticket);
    })
    .catch(error=>{
      console.error('Error fetching data:', error);  // 에러 처리	
    })
  },[])
  
  
  function buyTicket(){
    axios.get('http://localhost:8080/spring/shop/buyTicket')
    .then(response=>{
      console.log(response.data);
      getMyWealth();
    })
    .catch(error=>{
      console.error('Error fetching data:', error);  // 에러 처리	
    })
  }

  function buyGold(){
    axios.get('http://localhost:8080/spring/shop/buyGold')
    .then(response=>{
      console.log(response.data);
      getMyWealth();
    })
    .catch(error=>{
      console.error('Error fetching data:', error);  // 에러 처리	
    })
  }

  return (
    <>
      <h2>플레이어1</h2>
      <button onClick={clearPartyApi}>파티 비우기</button>
      <CardArea>
        {p1Party.map((cd,index)=>(
          <Card key={index} pokemon={cd.pokemon} grade={cd.grade} at={cd.attack} df={cd.defense}/>
        ))}
      </CardArea>
        총 공격력 : {totalAtP1}<br></br>
        총 방어력 : {totalDfP1}<br></br>
      <br></br>
      <button onClick={gachaApi1}>카드뽑기</button>
      <button onClick={clearCardListApi}>카드 리스트 삭제</button>
      <CardArea>
        {player1.map((cd, index) => (
          <Card key={index} pokemon={cd.pokemon} grade={cd.grade} at={cd.attack} df={cd.defense}
            adp={()=>adpc(index,cd.no)} />
        ))}
      </CardArea>
      <fieldset>
        <legend>상점</legend>
        <p>{ticket}🎫</p>
        <p>{gold}💰</p>
        <button onClick={buyTicket}>티켓 구매</button>
        <button onClick={buyGold}>골드 충전(1만원)</button>
      </fieldset>
    </>
  )
}

export default App;