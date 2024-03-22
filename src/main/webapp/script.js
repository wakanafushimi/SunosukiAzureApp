//-------------------peersページ-------------------------------
//idをふる
var openmodals = document.querySelectorAll(".openmodal");
var popups = document.querySelectorAll(".popup");
var cancels = document.querySelectorAll(".cancel");

//クリックしたらopen
for (let i = 0; i < openmodals.length; i++) {
	openmodals[i].addEventListener('click', createModalHandler(i));

}
function createModalHandler(index) {
	return function() {
		popups[index].style.display = 'block';
	};
}

//クリックしたらしまう
for (let i = 0; i < cancels.length; i++) {
	cancels[i].addEventListener('click', hidePopups(i));
}
function hidePopups(index) {
	return function() {
		popups[index].style.display = 'none';
	}
}


//-------------------sessionページ-------------------------------
var openmemberdetails = document.querySelectorAll(".openmemberdetail");
var memberdetailpopups = document.querySelectorAll(".memberdetailpopup");
var cancelmemberdetails = document.querySelectorAll(".cancelmemberdetail");
var memberdetaillists = document.querySelectorAll(".memberdetaillist");

//クリックしたらopen
for (let i = 0; i < openmemberdetails.length; i++) {
	openmemberdetails[i].addEventListener('click', openMemberdetail(i));

}
function openMemberdetail(index) {
	return function() {
		memberdetailpopups[index].style.display = 'block';

	};
}

//クリックしたらしまう
for (let i = 0; i < cancelmemberdetails.length; i++) {
	cancelmemberdetails[i].addEventListener('click', hideMemberpopups(i));
}
function hideMemberpopups(index) {
	return function() {
		memberdetailpopups[index].style.display = 'none';
	}
}


//-------------------deleteBtn------------------------------
const deleteBtn=document.getElementById("deleteBtn");
if(deleteBtn){
	deleteBtn.addEventListener("click",()=>{
		alert("Are you sure you delete it?")
	})
}

//-------------------都道府県-ゲレンデ-------------------------------
const gerende = document.getElementById('gerende');
const prefecture = document.getElementById('prefecture');
prefecture.addEventListener('change', (e) => {
  gerende.style.display="block";
});


const gerendeselect = document.getElementById("gerendeselect");

async function initAreaSelector(){
    await updatePref()
    await updateCity()
}

async function getPrefs(){
    const prefResponse=await fetch("json/prefectures.json")
    return await prefResponse.json()
}
async function getCities(prefCode){
    const cityResponse=await fetch(`json/${prefCode}.json`)
    return await cityResponse.json()
}
async function updatePref(){
    const prefs=await getPrefs()
    createPrefOptionsHtml(prefs)
}
async function updateCity(){
    const prefSelectorElm=gerendeselect.querySelector(".prefectures")
    const cities=await getCities(prefSelectorElm.value)
    createCityOptionsHtml(cities)
}
function createPrefOptionsHtml(prefs){
    const optionStrs=[]
    for(const pref of prefs){
        optionStrs.push(`
            <option name="${pref.name}" value="${pref.code}">
                ${pref.name}
            </option>
        `)
    }
    const prefSelectorElm=gerendeselect.querySelector(".prefectures")
    prefSelectorElm.innerHTML=optionStrs.join("")
    prefSelectorElm.addEventListener("change",(event)=>{
        updateCity()
    })
}

function createCityOptionsHtml(cities){
    const optionStrs=[]
    for(const city of cities){
        optionStrs.push(`
            <option name="${city.name}" value="${city.name}">
                ${city.name}
            </option>
        `)
    }
    const citySelectorElm=gerendeselect.querySelector(".gerende")
    citySelectorElm.innerHTML=optionStrs.join("")
}

initAreaSelector()