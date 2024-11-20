import './App.css';
import axios from 'axios';
import React, { useState } from 'react';

function PhysicalOrMagic(characterClass, oPower, mPower) {
    const magicClasses = ['단아', '이비', '체른', '미울', '아리샤', '테사', '라티야', '헤기'];
    if (magicClasses.includes(characterClass)) {
        return <>마법공격력:{mPower}</>;
    } else {
        return <>공격력:{oPower}</>;
    }
}

function Character({characterName, characterClass, level, oPower, mPower, anDamage, critical, balance, urAttacks}){
    return(
        <div className={`character ${characterClass}`}>
            <div id='info'>
                이름:{characterName}<br />
                레벨:{level}<br />
                {PhysicalOrMagic(characterClass, oPower, mPower)}<br />
                추가피해:{anDamage}<br />
                크리티컬:{critical}<br />
                밸런스:{balance}<br />
                공해제:{urAttacks}
            </div>
        </div>
    )
}

function CharacterArea({children}){
    return(
        <div id='character_area'>
            {children}
        </div>
    )
}


function App() {

    const [name, setName] = useState('');
    const [character, setCharacter] = useState([]);

    function searchCharacter(event) {
        event.preventDefault();
        console.log(`검색한 이름 : ${name}`);
        axios.get(`http://localhost:8080/spring/mh/characterSearch?name=${name}`)
            .then(response => {
                console.log(response.data);
                setCharacter([...character, response.data]);
            })
            .catch(error => {
                console.error('에러임', error);
            })
    }

    return (
        <div>
            <h3>파티구성</h3>
            <CharacterArea>

            </CharacterArea>

            <h3>캐릭터 검색</h3>
            <CharacterArea>
                {character.map((c,index)=>(
                    <Character key={index} characterName={c.character_name} characterClass={c.class_name} level={c.level} oPower={c.offensive_power} mPower={c.magic_power} 
                    anDamage={c.additional_damage} critical={c.critical} balance={c.balance} urAttacks={c.unrestricting_Attacks}/>
                ))}
            </CharacterArea>
            <br></br>
            <form onSubmit={searchCharacter}>
                <input value={name} onChange={(e) => setName(e.target.value)} placeholder='닉네임을 입력하세요' />
                <button type='submit'>검색</button>
            </form>
        </div>
    );
}
export default App;