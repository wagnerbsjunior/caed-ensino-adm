import { Component, AfterViewInit } from '@angular/core';

declare var $: any;

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements AfterViewInit {

  public isCollapsed = false;

  constructor() { }

  ngAfterViewInit(): void {
    var path = location.pathname;
    
    $('#layoutSidenav_nav .sb-sidenav a.nav-link').each((index:any, element:any) => {
        if ($(element).attr('href') === path) {
            $(element).addClass("active");
        }
    });
    
    $("#sidebarToggle").on("click", function (event: { preventDefault: () => void; }) {
        $("body").toggleClass("sb-sidenav-toggled");
    });
  }
 
}
