/**
 * Study from book <Effective Javascript>
 */
/*  Higher-Order Functions 
Higher-order functions are functions that take other functions as 
arguments or return functions as their result.
*/
var names = ["Fred", "Wilma", "Pebbles"];
var upper = [];
for (var i = 0, n = names.length; i < n; i++) {
	upper[i] = names[i].toUpperCase();
}
upper; // ["FRED", "WILMA", "PEBBLES"]

console.log(upper);

var aIndex = "a".charCodeAt(0); // 97
var alphabet = "";
for (var i = 0; i < 26; i++) {
	alphabet += String.fromCharCode(aIndex + i);
}
console.log(alphabet);

var random = "";
for (var i = 0; i < 8; i++) {
	random += String.fromCharCode(Math.floor(Math.random() * 26) + aIndex);
}
console.log(random);

function buildString(n, callback) {
	var result = "";
	for (var i = 0; i < n; i++) {
		result += callback(i);
	}
	return result;
}

alphabet = buildString(26, function(i) {
	return String.fromCharCode(aIndex + i);
});
console.log(alphabet);

var digits = buildString(10, function(i) {
	return i;
});
console.log(digits); // "0123456789"

random = buildString(8, function() {
	return String.fromCharCode(Math.floor(Math.random() * 26) + aIndex);
});
console.log(random);
// End Higher-Order Functions

/*
Use call to Call Methods with a Custom Receiver
 */
var table = {
	entries: [],
	addEntry: function(key, value) {
		this.entries.push({
			key: key,
			value: value
		});
	},
	forEach: function(f, thisArg) {
		var entries = this.entries;
		for (var i = 0, n = entries.length; i < n; i++) {
			var entry = entries[i];
			f.call(thisArg, entry.key, entry.value, i);
		}
	}
};

var table1 = table;
table1.addEntry('Name', 'Robin');
table1.addEntry('Age', '30');
console.log(table1);

var table2 = table;
table1.forEach(table2.addEntry, table2);
console.log(table2);
// End Use call

/*
Use apply to Call Functions with Different Numbers of Arguments
*/
var buffer = {
	state: [],
	append: function() {
		for (var i = 0, n = arguments.length; i < n; i++) {
			this.state.push(arguments[i]);
		}
	},
	concat: function() {
		return this.state.join("");
	}
};

var firstName = "Bin";
var lastName = "Ye";

buffer.append("Hello, ");
buffer.append(firstName, " ", lastName, "!");
buffer.append('\n');
buffer.append.apply(buffer, upper);

console.log(buffer);
// End apply


/*
Use a Variable to Save a Reference to arguments 
Be aware of the function nesting level when referring to arguments.
 */
function values() {
	var i = 0,
		n = arguments.length,
		a = arguments;
	return {
		hasNext: function() {
			return i < n;
		},
		next: function() {
			if (i >= n) {
				throw new Error("end of iteration");
			}
			return a[i++];
		}
	};
}
var it = values(1, 4, 1, 4, 2, 1, 3, 5, 6);
console.log(it.next()); // 1
console.log(it.next()); // 4
console.log(it.next()); // 1
// End 


/*
Use bind to Curry Functions 
Use bindto curry a function, that is, to create a delegating function 
with a fixed subset of the required arguments.
 */
function simpleURL(protocol, domain, path) {
	return protocol + "://" + domain + "/" + path;
}

var paths = ['1.jsp', '2.jsp', '3.jsp'];
var siteDomain = 'localhost';

// var urls = paths.map(function(path) {
// 	return simpleURL("http", siteDomain, path);
// });

var urls = paths.map(simpleURL.bind(null, "http", siteDomain));
console.log(urls);
// End Curry

/*
Prefer Closures to Strings for Encapsulating Code
*/
function repeat(n, action) {
	for (vari = 0; i < n; i++) {
		action();
	}
}

function benchmark() {
	var start = [],
		end = [],
		timings = [];
	repeat(10, function() {
		start.push(Date.now());
		// function to test
		table1.forEach(table2.addEntry, table2);
		end.push(Date.now());
	});

	for (var i = 0, n = start.length; i < n; i++) {
		timings[i] = end[i] - start[i];
	}

	return timings;
}

console.log(benchmark());
// End

/*
Make Your Constructors new-Agnostic
Document clearly when a function expects to be called with new 
 */

if (typeof Object.create === "undefined") {
	Object.create = function(prototype) {
		function C() {}
		C.prototype = prototype;
		return new C();
	};
}

function User(name, passwordHash) {
	var self = this instanceof User ? this : Object.create(User.prototype);
	self.name = name;
	self.passwordHash = passwordHash;
	return self;
}

var x = User("baravelli", "d8b74df393528d51cd19980ae0aa028e");
var y = new User("baravelli", "d8b74df393528d51cd19980ae0aa028e");
console.log(x);
console.log(x instanceof User);
console.log(y);
console.log(y instanceof User);
// End

/*
 
 */
function CSVReader(separators) {
	this.separators = separators || [","];
	this.regexp =
		new RegExp(this.separators.map(function(sep) {
			return "\\" + sep[0];
		}).join("|"));
}

// Solution 1
// Take advantage of the fact that the mapmethod of arrays takes an optional 
// second argument to use as a this-binding for the callback
/*
CSVReader.prototype.read = function(str) {
	var lines = str.trim().split(/\n/);
	return lines.map(function(line) {
		return line.split(this.regexp);
	}, this); // forward outer this-binding to callback
};
*/

// Solution 2
// Use a local variable, usually called self, me, or that, to make a 
// this-binding available to inner functions.
/*
CSVReader.prototype.read = function(str) {
	var lines = str.trim().split(/\n/);
	var self = this; // save a reference to outer this-binding
	return lines.map(function(line) {
		return line.split(self.regexp); // use outer this
	});
};
*/

// Solution 3
// ES5 is to use the callback function’s bindmethod
CSVReader.prototype.read = function(str) {
	var lines = str.trim().split(/\n/);
	return lines.map(function(line) {
		return line.split(this.regexp);
	}.bind(this)); // bind to outer this-binding
};

var reader = new CSVReader();
console.log(reader.read("a,b,c\nd,e,f\n"));
// End

/*
In ES5, use  Object.create(null)to create prototype-free empty 
objects that are less susceptible to pollution.
*/
var x = Object.create(null);
console.log(Object.getPrototypeOf(x) === null); // true
// End

/*
Use hasOwnPropertyto protect against prototype pollution. 
 */
function Dict(elements) {
	// allow an optional initial table
	this.elements = elements || {}; // simple Object
	this.hasSpecialProto = false; // has "__proto__" key?
	this.specialProto = undefined; // "__proto__" element
}
Dict.prototype.has = function(key) {
	if (key === "__proto__") {
		return this.hasSpecialProto;
	}
	// own property only
	return {}.hasOwnProperty.call(this.elements, key);
};
Dict.prototype.get = function(key) {
	if (key === "__proto__") {
		return this.specialProto;
	}
	// own property only
	return this.has(key) ? this.elements[key] : undefined;
};
Dict.prototype.set = function(key, val) {
	if (key === "__proto__") {
		this.hasSpecialProto = true;
		this.specialProto = val;
	} else {
		this.elements[key] = val;
	}
};
Dict.prototype.remove = function(key) {
	if (key === "__proto__") {
		this.hasSpecialProto = false;
		this.specialProto = undefined;
	} else {
		delete this.elements[key];
	}
};


var dict = new Dict({
	alice: 34,
	bob: 24,
	chris: 62
});
console.log(dict.has("alice")); // true
console.log(dict.get("bob")); // 24
console.log(dict.has("valueOf")); // false
console.log(dict.has("__proto__")); // false
// End


/*
Avoid adding properties to Object.prototype.
Consider writing a function instead of an Object.prototypemethod.
If you do add properties to  Object.prototype, use ES5’s 
Object.definePropertyto define them as nonenumerable properties. 
 */
Object.defineProperty(Object.prototype, "allKeys", {
	value: function() {
		var result = [];
		for (var key in this) {
			result.push(key);
		}
		return result;
	},
	writable: true,
	enumerable: false,
	configurable: true
});
console.log(({
	a: 1,
	b: 2,
	c: 3
}).allKeys());
// End

/*
Use iteration methods such as Array.prototype.forEachand 
Array.prototype.mapin place of forloops to make code more readable and avoid duplicating loop control logic.
 */
var input = ['a ', 'b ', ' c'];
var trimmed = [];
for (var i = 0, n = input.length; i < n; i++) {
	trimmed.push(input[i].trim());
}
console.log(trimmed);

trimmed = [];
input.forEach(function(s) {
	trimmed.push(s.trim());
});
console.log(trimmed);

trimmed = input.map(function(s) {
	return s.trim();
});
console.log(trimmed);
// End

/*
Reuse generic Arraymethods on array-like objects by extracting 
method objects and using their callmethod.
Any object can be used with generic Arraymethods if it has indexed 
properties and an appropriate lengthproperty. 
 */
function highlight() {
	[].forEach.call(arguments, function(widget) {
		widget.setBackground("yellow");
	});
}

var arrayLike = {
	0: "a",
	1: "b",
	2: "c",
	length: 3
};
var result = Array.prototype.map.call(arrayLike, function(s) {
	return s.toUpperCase();
}); // ["A", "B", "C"]
console.log(result);

result = Array.prototype.map.call("abc", function(s) {
	return s.toUpperCase();
}); // ["A", "B", "C"]
console.log(result);

function namesColumn() {
	return ["Names"].concat([].slice.call(arguments));
}
console.log(namesColumn("Alice", "Bob", "Chris"));
// ["Names", "Alice", "Bob", "Chris"]
// End

/*
Test for undefinedinstead of checking arguments.length to provide 
parameter default values.
 */
function Element(width, height) {
	this.width = width === undefined ? 320 : width;
	this.height = height === undefined ? 240 : height;
	// ...
}
var c1 = new Element(0, 0);
console.log(c1.width); // 0
console.log(c1.height); // 0

var c2 = new Element();
console.log(c2.width); // 320
console.log(c2.height); // 240
// End

/*
Use options objects to make APIs more readable and memorable.
The arguments provided by an options object should all be treated 
as optional.
Use an extendutility function to abstract out the logic of extracting 
values from options objects. 
 */
function extend(target, source) {
	if (source) {
		for (var key in source) {
			var val = source[key];
			if (typeof val !== "undefined") {
				target[key] = val;
			}
		}
	}
	return target;
}

function Alert(parent, message, opts) {
	opts = extend({
		width: 320,
		height: 240
	});
	opts = extend({
		x: (parent.width / 2) - (opts.width / 2),
		y: (parent.height / 2) - (opts.height / 2),
		title: "Alert",
		titleColor: "gray",
		bgColor: "white",
		textColor: "black",
		icon: "info",
		modal: false
	}, opts);
	extend(this, opts);
}

var alert = new Alert('', 'test', {
	width: 150,
	height: 100,
	title: "Error",
	titleColor: "blue",
	bgColor: "white",
	textColor: "black",
	icon: "error",
	modal: true
});
console.log(alert);
// End

/*
Use ES5’s Array.isArrayto test for true arrays. 
 */
var toString = Object.prototype.toString;

function isArray(x) {
	return toString.call(x) === "[object Array]";
}
// End

/*
Support Method Chaining
*/
function escapeBasicHTML(str) {
	return str.replace(/&/g, "&amp;")
		.replace(/</g, "&lt;")
		.replace(/>/g, "&gt;")
		.replace(/"/g, "&quot;")
		.replace(/'/g, "&apos;");
}

// End