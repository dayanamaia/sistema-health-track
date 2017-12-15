'use strict';

function main() {

    // slider - bg index
    var bgSlider = function bgSlider() {
        var slideItem = $('.slide-item');

        slideItem.each(function () {
            var data = $(this).data('img');
            var url = 'resources/images/pages/account/' + data;

            $(this).css('background-image', 'url(' + url + ')');
        });
    };

    // menu mobile
    var toggleNav = function toggleNav() {
        $('header').toggleClass('open-nav');
    };

    // menu add new category
    var toggleAddCategory = function toggleAddCategory() {
        $('.add-category-list').toggle();
    };

    var closeModal = function closeModal() {
        $('.bg-overlay, .modal-delete').hide();
    };
    
    // open modal delete
    var modalDelete = function modal(e) {
    	var form = e.currentTarget.getAttribute('data-form');
    	var id = e.currentTarget.getAttribute('data-id');
    	
    	$(".modal-delete form").attr("action", form);
    	$("#idExcluir").val(id);
    	$('.bg-overlay, .modal-delete').show();
    };

    // form validate
    var validate = function validate() {
        var form = $('.form form');
        var inputDate = form.find('input[name="date"]');
        var inputHeight = form.find('input[name="height"]');
        var inputWeight = form.find('input[name="weight"]');
        var inputNumber = form.find('input.number');
        var inputHours = form.find('input[name="hours"]');

        inputDate.mask('00/00/0000', { placeholder: '__/__/____' });
        inputHeight.mask('0.00', { placeholder: '0.00' });
        inputWeight.mask('#000.0', { reverse: true, placeholder: '00.00' });
        inputNumber.mask('0#');
        inputHours.mask('00:00', { placeholder: '00:00' });

        $.validator.addMethod('date', function (value, element) {
            var check = false;
            var re = /^\d{1,2}\/\d{1,2}\/\d{4}$/;
            if (re.test(value)) {
                var value = value.split('/');
                var numberValue = [];

                value.forEach(function (element, index, array) {
                    numberValue.push(parseInt(element, 10));
                });

                var day = numberValue[0];
                var month = numberValue[1];
                var year = numberValue[2];
                var date = new Date(year, month - 1, day);

                if (date.getFullYear() == year && date.getMonth() == month - 1 && date.getDate() == day) {
                    check = true;
                } else {
                    check = false;
                }
            } else {
                check = false;
            }
            return check;
        });

        $.validator.addMethod('option', function (value, element, arg) {
            return arg !== value;
        });

        form.validate({
            rules: {
                email: {
                    required: true,
                    email: true
                },
                password: {
                    required: true,
                    minlength: 8,
                    maxlength: 8
                },
                repeat_password: {
                    required: true,
                    minlength: 8,
                    maxlength: 8,
                    equalTo: '#password'
                },
                date: {
                    required: true,
                    date: true
                },
                height: {
                    required: true,
                    minlength: 4,
                    maxlength: 4,
                    number: true
                },
                number: {
                    required: true,
                    digits: true
                },
                type_meal: {
                    required: true,
                    option: 'empty'
                },
                type_food: {
                    required: true,
                    option: 'empty'
                },
                type_fitnes: {
                    required: true,
                    option: 'empty'
                },
                time_food: {
                    required: true,
                    option: 'empty'
                },
                medication: {
                    required: true,
                    option: 'empty'
                }
            },
            submitHandler: function submitHandler(form) {
                form.submit();
            }
        });
    };

    //Date today
    var getDate = function getDate() {
        var dateForm = $('.admim-items [name="date"]');
        var elToday = $('.today p');
        var months = ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'];
        var date = new Date();
        var monthName = months[date.getMonth()];

        var day = date.getDate();
        var month = date.getMonth() + 1;
        var year = date.getFullYear();

        dateForm.val(day + '/' + month + '/' + year);
        elToday.text(day + ' de ' + monthName + ' de ' + year);
    };

    //slider - slick
    $('.slide').slick({
        infinite: true,
        autoplay: true,
        autoplaySpeed: 4000,
        pauseOnHover: false,
        fade: true,
        cssEase: 'linear',
        speed: 400,
        slidesToShow: 1,
        slidesToScroll: 1,
        arrows: false,
        dots: true
    });

    //category - slick
    $('.boxes-category').slick({
        infinite: true,
        autoplay: true,
        autoplaySpeed: 4000,
        pauseOnHover: false,
        speed: 400,
        arrows: false,
        dots: true,
        responsive: [{
            breakpoint: 99999,
            settings: 'unslick'
        }, {
            breakpoint: 800,
            settings: {
                slidesToShow: 1,
                slidesToScroll: 1
            }
        }]
    });

    $('header').before().on('click', function () {
        toggleNav();
    });

    $('body').on('click', '.modal-delete .close, .modal-delete .cancel, .bg-overlay', function (e) {
        e.preventDefault();
        closeModal();
    });

    $('.add-category-button').on('click', function (e) {
        e.preventDefault();
        toggleAddCategory();
    });

    $('.item-admin .delete').on('click', function (e) {
        e.preventDefault();
        modalDelete(e);
    });

    bgSlider();
    validate();
    getDate();
}

$(document).ready(main);