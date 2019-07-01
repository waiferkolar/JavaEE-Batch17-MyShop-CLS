function addToCart(id) { // store data to local storage
	let items = getFromDB();
	if (items) {
		let ind = items.findIndex(it => it.item_id == id);
		if(ind == -1){
			let obj = {
					"item_id" : id,
					"count" : 1
				}
			items.push(obj);
			saveToDB(items);
		}else{
			let obj = items[ind];
			obj.count = obj.count + 1;
			saveToDB(items);
		}
	} else {
		let obj = {
			"item_id" : id,
			"count" : 1
		}
		items = [];
		items.push(obj);
		saveToDB(items);
	}
}

function saveToDB(val) {
	val = JSON.stringify(val);
	localStorage.setItem("cartdb", val);
	incrementCartCount();
}
function getFromDB() {
	let str = localStorage.getItem("cartdb");
	return JSON.parse(str);
}
function incrementCartCount(){
	let items = getFromDB();
	document.querySelector(".my_cart").innerHTML = items.length;
}
incrementCartCount();
// removeDB();
let products = null;
function loadCartItems(){
	let items = getFromDB();
	let itemString = "";
	items.forEach((item,i)=>{
		if(i != (items.length-1)){
			itemString += item.item_id + ",";
		}else{
			itemString += item.item_id;
		}
	});
	console.log(itemString);
 fetch("http://localhost:8080/MyShop/ApiController?route=cart_detail&ids="+itemString)
	 .then((response)=>{
		 return response.text();
	 })
	 .then((res)=>{
		products = JSON.parse(res);
		loadData();
 })
 .catch((err)=>{
 console.log(err);
 })
}
function loadData(){
	let str = "";
	 let t = 0;
	 products.forEach((product)=>{
		 t++;
		 str += `
		 <tr>
			 <td class="text-info">${t}</td>
			 <td>${product.name}</td>
			 <td><img
			 src="${product.image}" style="width:100px;height:50px;"/></td>
			 <td>$ ${product.price}</td>
			 <td>
			 <button class="btn btn-success btn-sm" onClick="addOneTo(${product.id})">
			 <i class="fa fa-plus"></i>
			 </button> <strong>${getSingleItemCount(product.id)}</strong>
			 <button class="btn btn-warning btn-sm" onClick="reduceOneTo(${product.id})">
			 <i class="fa fa-minus"></i>
			 </button>
			 <button class="btn btn-danger btn-sm" onClick="deleteOne(${product.id})">
			 <i class="fa fa-trash"></i>
			 </button>
			 </td>
			 <td>$ ${product.price * getSingleItemCount(product.id)}</td>
		 </tr>
		 `;
});
document.querySelector("#tbody").innerHTML = str;
}

function deleteOne(id){
	let items = getFromDB();
	let ind = items.findIndex(it => it.item_id==id);
	let item = items[ind];
	items.splice(ind,1);
	
	
	let pInd = products.findIndex(pa => pa.id == id);
	product = products[pInd];
	products.splice(pInd,1);
	loadData();
	
	saveToDB(items);
}

function addOneTo(id){
	let items = getFromDB();
	let ind = items.findIndex(it => it.item_id==id);
	let item = items[ind];
	item.count = item.count + 1;
	
	saveToDB(items);
	loadData();
}
function reduceOneTo(id){
	let items = getFromDB();
	let ind = items.findIndex(it => it.item_id==id);
	let item = items[ind];
	if(item.count > 1){
		item.count = item.count - 1;
	}
	saveToDB(items);
	loadData();
}

function getSingleItemCount(id){
	let items = getFromDB();
	let ind = items.findIndex(it => it.item_id==id);
	let item = items[ind];
	return item.count;
}

function removeDB(val) {
	val = JSON.stringify(val);
	localStorage.removeItem("cartdb");
	incrementCartCount();
}