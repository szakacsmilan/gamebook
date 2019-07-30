let monsterHp = document.getElementById('monsterHp');
let playerHp = document.getElementById('playerHp');
let button = document.getElementById('button');

button.addEventListener('click', fight);


async function fight() {

    await saveHp();

    let monster;
    let player;

    fetch("http://localhost:9090/monster/lizard")
        .then(res => res.json())
        .then(json => {
            monster = json.hp;
            if(monster<0){
                document.getElementById("isMonsterDead").innerHTML = "<p> Megölted a Gyík királyt! </p>";
                button.style.display = "none";
            }else{
                monsterHp.innerText = monster;
            }
    });
    fetch("http://localhost:9090/monster/player")
        .then(res => res.json())
        .then(json => {
            player = json.hp;
            if(player<0){
                document.getElementById("isPlayerDead").innerHTML = "<p> Megholtal! </p>";
                button.style.display = "none";
            }else{
                playerHp.innerText = player;
            }
        });


}

function saveHp() {

    return fetch("http://localhost:9090/fight");

}