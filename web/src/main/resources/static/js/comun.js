function onPageLoad() {
    setRandomPhrase()
    menuToggleHeader()
    setRandomImages()
    setPreloader()
    rankingToggle()
}

function setPreloader() {
    const preloader = document.getElementById('preloader');

    // Espera un mínimo de 2 segundos antes de ocultar
    setTimeout(() => {
        preloader.classList.add('opacity-0', 'pointer-events-none');
        setTimeout(() => {
            preloader.style.display = 'none';
        }, 500); // da tiempo a la transición
    }, 300); // <-- ajusta este valor según lo que necesites
}
function setRandomImages() {
    const images = [
        '../img/img1.png',
        '../img/img2.png',
        '../img/img3.png',
        '../img/img4.png',
        '../img/img5.png',
        '../img/img6.png',
        '../img/img7.png',
        '../img/img8.png',
        '../img/img9.png',
        '../img/img10.png',
        '../img/img11.png',
        '../img/img12.png',
        '../img/img13.png',
        '../img/img14.png',
        '../img/img15.png',


    ];
    const elements = document.querySelectorAll('.img_random');
    const usedIndexes = new Set();

    elements.forEach(el => {
        let randomIndex;

        // Buscar un índice que no se haya usado aún
        do {
            randomIndex = Math.floor(Math.random() * images.length);
        } while (usedIndexes.has(randomIndex) && usedIndexes.size < images.length);

        usedIndexes.add(randomIndex);
        el.style.backgroundImage = `url('${images[randomIndex]}')`;
    });
}
function menuToggleHeader() {
    const hamburger = document.getElementById('hamburger');
    const navMenu = document.getElementById('navMenu');
    const img_toggle = document.getElementById('img_toggle');


    hamburger.addEventListener('click', () => {
        navMenu.classList.toggle('hidden');
        navMenu.classList.toggle('opacity-0');
        navMenu.classList.toggle('opacity-100');
        navMenu.classList.toggle('translate-x-0');
        img_toggle.classList.toggle('rotate-0');
    })
}

function rankingToggle() {
    const toggleBtn = document.getElementById('toggle-btn');
    let expanded = false;

    toggleBtn.addEventListener('click', function () {
        const extras = document.querySelectorAll('.extra-fighter');
        expanded = !expanded;

        extras.forEach(el => {
            el.classList.toggle('hidden', !expanded);
        });

        this.textContent = expanded ? 'see less' : 'see more';

        if (!expanded) {
            window.scrollTo({ top: 0, behavior: 'smooth' });
        }
    });
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


window.addEventListener('load', onPageLoad);