"use strict";

export const Work_CSS_module = (() => {

    class My_Scroll_class {

        constructor(element) {
            this.element = element;
            this.element.pos = { top: 0, left: 0, x: 0, y: 0 };
            this.element.addEventListener('mousedown', this.mouseDownHandler);
          }
    
          mouseDownHandler = (event) => {
            this.element.style.cursor = 'grabbing';
            this.element.style.userSelect = 'none';
        
            this.element.pos = {
                left: this.element.scrollLeft,
                top: this.element.scrollTop,
                
                x: event.clientX,
                y: event.clientY,
            };
            
            this.element.addEventListener('mousemove', this.mouseMoveHandler);
            this.element.addEventListener('mouseup', this.mouseUpHandler);
            
        };
        
        
        mouseMoveHandler = (event) => {
            const dx = event.clientX - this.element.pos.x;
            const dy = event.clientY - this.element.pos.y;
    
            this.element.scrollTop = this.element.pos.top - dy;
            this.element.scrollLeft = this.element.pos.left - dx;
        };
        
        mouseUpHandler = (event) => {
            this.element.style.cursor = 'grab';
    
            this.element.removeEventListener('mousemove', this.mouseMoveHandler);
            this.element.removeEventListener('mouseup', this.mouseUpHandler);
        };
    
        
    };

    let My_Scroll = element => {
        return new My_Scroll_class(element);
    };

    return {
        My_Scroll: My_Scroll
    };
    
})();



