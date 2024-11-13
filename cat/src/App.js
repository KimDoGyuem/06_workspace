import axios from 'axios';
import React, { useState, useEffect } from 'react';
import './App.css';

function Card({ job, grade, xxx}) {
  return (
    <div className={`card ${job} ${grade}`} onClick={xxx}>
      {job} - {grade} {/* job과 grade를 표시 */}
    </div>
  );
}

function CardArea({ children }) {
  return (
    <div id='card_area'>
      {children}
    </div>
  );
}


function App() {

  useEffect(() => {		
    console.log('컴포넌트가 생성됨');	
    getMyCardApi();
  }, []);	

  function cat(index,j,g){
    console.log(`보유카드 번호: ${index}`);
    alert(`보유카드 번호: ${index} 직업: ${j} 등급:${g}`);
    var p = {job: j, grade: g};
    setParty([...party, p]);
    partyAdd(p);
  }

  function partyAdd(p){
    axios.post('http://localhost:8080/spring/card/partyAdd',p)			
    .then(response => {		
      console.log(response.data);
    })		
    .catch(error => {		
      console.error('Error fetching data:', error); 
    });		
  }

  function gachaApi(){
    axios.get('http://localhost:8080/spring/card/gacha')			
    .then(response => {		
      console.log(response.data);  // 서버로부터 받은 데이터 출력	
          // 기존의 `my` 배열을 복사하고, 새 객체를 추가한 새로운 배열로 업데이트
      setMy([...my, response.data]);
    })		
    .catch(error => {		
      console.error('Error fetching data:', error);  // 에러 처리	
    });		
  }

  function getMyCardApi(){
    axios.get('http://localhost:8080/spring/card/getMyCards')			
    .then(response => {		
      console.log(response.data);  // 서버로부터 받은 데이터 출력	
          // 기존의 `my` 배열을 복사하고, 새 객체를 추가한 새로운 배열로 업데이트
      setMy([...my, ...response.data]);
    })		
    .catch(error => {		
      console.error('Error fetching data:', error);  // 에러 처리	
    });		
  }

  function reset(){
    setMy([]);
  }
  
  function del(){
    axios.get('http://localhost:8080/spring/card/listDelete')			
    .then(response => {		
      console.log(response.data);  // 서버로부터 받은 데이터 출력	
      // 기존의 `my` 배열을 복사하고, 새 객체를 추가한 새로운 배열로 업데이트
      setMy([]);
    })		
    .catch(error => {		
      console.error('Error fetching data:', error);  // 에러 처리	
    });		
  }

  var [my,setMy] = useState([]);
  const [party, setParty] = useState([]);

  return (
    <>
      <h2>파티 1</h2>
      <CardArea>
        {party.map((character, index) => (
          <Card key={index} job={character.job} grade={character.grade} />
        ))}
      </CardArea>

      <h2>보유</h2>
      <button onClick={gachaApi}>카드 1뽑 by api</button>
      <CardArea>
        {my.map((character, index) => (
          <Card key={index} job={character.job} grade={character.grade} 
          xxx={()=>cat(index, character.job, character.grade)}
          />
        ))}
      </CardArea>
        <button onClick={reset}>리셋</button>
        <button onClick={del}>나의 카드 리스트 삭제</button>

      <h2>적</h2>
      <CardArea>
        {party.map((character, index) => (
          <Card key={index} job={character.job} grade={character.grade} />
        ))}
      </CardArea>
    </>
  );
}

export default App;
