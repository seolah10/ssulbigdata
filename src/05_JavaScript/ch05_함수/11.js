// JavaScript source code
function sumAll() {
    var result = 0;

    if (arguments.length == 0) {
        result = -999;
    } else {
        for (var idx in arguments) {
            result += arguments[idx];
        }
    }
    return result;
};