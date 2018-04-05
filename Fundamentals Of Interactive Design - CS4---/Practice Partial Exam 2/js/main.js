$('.keypoints a').click(function() {
  previous = $('.keypoints .selected')
  previousKey = previous.data('key')
  previous.removeClass('selected')
  $(this).addClass('selected')

  let selectedKey = $(this).data('key')

  if (selectedKey != previousKey) {
    $('.aside').hide()

    switch (selectedKey) {
      case 1:
        $('#item-1').fadeIn()
        break
      case 2:
        $('#item-2').fadeIn()
        break
      case 3:
        $('#item-3').fadeIn()
        break
      case 4:
        $('#item-4').fadeIn()
        break
      case 5:
        $('#item-5').fadeIn()
        break
      default:
        $('#item-1').fadeIn()
        break
    }
  }
})

$('#menu').click(function(e) {
  e.preventDefault();
  $('ul').slideToggle('active');
});
