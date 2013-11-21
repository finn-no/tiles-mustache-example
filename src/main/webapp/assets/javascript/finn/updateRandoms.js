/*global jQuery, bartefrans*/
var FINN = FINN || {};
(function($, bartefrans) {
    "use strict";

    $('[data-random-control]').on('click',function(){
        bartefrans.renderTemplateWithDataFromUrl('/tiles/template/page.random/body.updateable', '/random.json', function(err, content) {
            if (err) {
                console.error('Error while rendering Mustache template!', err);
                return;
            }

            $('[data-random-container]').html(content);
        });
    });

})(jQuery, bartefrans);