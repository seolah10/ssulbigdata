// JavaScript source code
Date.prototype.getInterval = function (that) {
    if (this > that) {
        var intervalMilli = this.getTime() - that.getTime();
    } else {
        var intervalMilli = that.getTime() - this.getTime();
    }

    var intervalDay = intervalMilli / (1000 * 60 * 60 * 24);
    return Math.trunc(intervalDay)
};
