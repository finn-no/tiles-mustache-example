;(function e(t,n,r){function s(o,u){if(!n[o]){if(!t[o]){var a=typeof require=="function"&&require;if(!u&&a)return a(o,!0);if(i)return i(o,!0);throw new Error("Cannot find module '"+o+"'")}var f=n[o]={exports:{}};t[o][0].call(f.exports,function(e){var n=t[o][1][e];return s(n?n:e)},f,f.exports,e,t,n,r)}return n[o].exports}var i=typeof require=="function"&&require;for(var o=0;o<r.length;o++)s(r[o]);return s})({1:[function(require,module,exports){
window.bartefrans = require('../src/bartefrans')(window.Mustache);
window.bartefrans.useFacade(require('../src/facades/jquery.js')());
},{"../src/bartefrans":2,"../src/facades/jquery.js":3}],2:[function(require,module,exports){
module.exports = function(Mustache) {
  var templates = {};
  var defaultFacade;

  function retrieveTemplate(templateUrl, callback, facade) {
    if (templates[templateUrl]) {
      callback(null, templates[templateUrl]);
    } else {
      getFacade(facade).load(templateUrl, function (err, response) {
        templates[templateUrl] = response;
        callback(err, response);
      });
    }
  }

  function renderTemplateWithData(templateUrl, data, callback, facade) {
    retrieveTemplate(templateUrl, function(err, template) {
      callback(err, Mustache.render(template, data));
    }, facade);
  }

  function renderTemplateWithDataFromUrl(templateUrl, dataUrl, callback, facade) {
    getFacade(facade).load(dataUrl, function(err, data) {
      renderTemplateWithData(templateUrl, data, callback, facade);
    });
  }

  function setTemplates(_templates) {
    templates = _templates;
  }

  function useFacade(facade) {
    if (typeof(facade.load) !== 'function') {
      throw new TypeError('Given facade does not implement facade interface!');
    }

    defaultFacade = facade;
  }

  function getFacade(facade) {
    return defaultFacade || facade;
  }

  return {
    renderTemplateWithData: renderTemplateWithData,
    renderTemplateWithDataFromUrl: renderTemplateWithDataFromUrl,
    setTemplates: setTemplates,
    useFacade: useFacade
  };
};
},{}],3:[function(require,module,exports){
module.exports = function(jQuery) {
  var $ = jQuery || window.jQuery;

  return {
    load: function(url, callback) {
      $.ajax({
        url: url,
        success: function(data) {
          callback(null, data);
        },
        error: function(jqXHR, textStatus, errorThrown) {
          callback(errorThrown);
        }
      });
    }
  };
};
},{}]},{},[1])
;