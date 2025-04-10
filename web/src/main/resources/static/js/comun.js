function onPageLoad() {
    setRandomPhrase()
    menuToggleHeader()
}

function menuToggleHeader() {
    const hamburger = document.getElementById('hamburger');
    const navMenu = document.getElementById('navMenu');


    hamburger.addEventListener('click', () => {
        navMenu.classList.toggle('hidden');
        navMenu.classList.toggle('opacity-0');
        navMenu.classList.toggle('opacity-100');
        navMenu.classList.toggle('translate-x-0');
    })
}
function setRandomPhrase() {
    const phrases = [
        "I'm not here to take part, I'm here to take over. – Conor McGregor",
        "I’ll knock him out in the first round. – Mike Tyson",
        "The best thing in life is to be able to do what you love. – Ronda Rousey",
        "I’m not afraid of anyone, I’ll fight anyone. – Khabib Nurmagomedov",
        "In the octagon, I’m in my zone. I’m just a different animal. – Jon Jones",
        "I’ve been fighting for a long time and I’m just getting started. – Daniel Cormier",
        "I’ll beat him, I’ll beat him to the ground, and then I’ll finish him. – Stipe Miocic",
        "If you can’t do something with a smile, don’t do it at all. – Georges St-Pierre",
        "You’re never as good as they say you are, you’re never as bad as they say you are. – Anderson Silva",
        "I’m just a guy from the hood trying to get better every day. – Nate Diaz",
        "There’s no easy fight in the UFC. You’ve got to be ready for anything. – Tony Ferguson",
        "I can’t be beat. – Demetrious Johnson",
        "Every day I wake up and I say to myself, ‘I’m going to be the best.’ – Max Holloway",
        "The harder I work, the harder it is to surrender. – Kamaru Usman",
        "Pain is temporary. Pride is forever. – BJ Penn",
        "I don’t fight for money, I fight for honor. – Fabrício Werdum",
        "I’ll do whatever it takes to win. – Holly Holm",
        "I will continue to break barriers and prove everyone wrong. – Amanda Nunes",
        "I am the best in the world, period. – Conor McGregor",
        "I don't want to be the best in the world, I want to be the best for the world. – Israel Adesanya"
    ];

    const numRandom = Math.floor(Math.random() * phrases.length);
    const phrase = document.getElementById("random_phrases");
    if (phrase) {
        phrase.textContent = phrases[numRandom];
    }else{
        phrase.textContent = "No phase available";
    }
}


window.onload = onPageLoad;