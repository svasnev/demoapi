'use strict';

var rest = require('rest');
var mime = require('rest/interceptor/mime');
var errorCode = require('rest/interceptor/errorCode');

module.exports = rest
	.wrap(mime)
	.wrap(errorCode);