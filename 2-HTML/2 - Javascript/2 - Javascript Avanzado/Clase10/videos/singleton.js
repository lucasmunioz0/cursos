(function() {

    let instance;

    function App() {
        if (!instance) {
            instance = Math.random();
        }
        this.id = instance;
    }
    window.app = App;
})();