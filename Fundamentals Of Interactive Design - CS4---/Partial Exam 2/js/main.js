$('.menu li').click(function() {
  previous = $('.menu .selected')
  previousKey = previous.data('key')
  previous.removeClass('selected')
  $(this).addClass('selected')

  let selectedKey = $(this).data('key')

  if (selectedKey != previousKey) {
    $('#wrapper section').hide()

    switch (selectedKey) {
      case 1:
        $('#home').delay(100).fadeIn()
        break
      case 2:
        $('#products').delay(100).fadeIn()
        break
      case 3:
        $('#services').delay(100).fadeIn()
        break
      case 4:
        $('#company').delay(100).fadeIn()
        break
      default:
        $('#home').delay(100).fadeIn()
        break
    }
  }
})


$('.hamburger').click(function(e) {
  e.preventDefault();
  $('ul').slideToggle('active');
});
