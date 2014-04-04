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