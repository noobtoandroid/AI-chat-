import 'package:flutter/material.dart';
import 'constants.dart';
import 'models.dart';

void main() {
  runApp(const LiteWorkspaceApp());
}

class LiteWorkspaceApp extends StatelessWidget {
  const LiteWorkspaceApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: AppConstants.appTitle,
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        useMaterial3: true,
        scaffoldBackgroundColor: const Color(0xFFFCF8F6),
        colorScheme: ColorScheme.fromSeed(
          seedColor: const Color(0xFF855353),
          brightness: Brightness.light,
          primary: const Color(0xFF352E2B),
          onPrimary: Colors.white,
          surface: const Color(0xFFFCF8F6),
          onSurface: const Color(0xFF1D1B1E),
        ),
      ),

      home: const ScaffoldingPage(),
    );
  }
}

class ScaffoldingPage extends StatefulWidget {
  const ScaffoldingPage({super.key});

  @override
  State<ScaffoldingPage> createState() => _ScaffoldingPageState();
}

class _ScaffoldingPageState extends State<ScaffoldingPage> {
  bool _isCompleted = false;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.transparent,
        elevation: 0,
        title: const Text(
          'Project Scaffolding',
          style: TextStyle(
            color: Color(0xFF1D1B1E),
            fontWeight: FontWeight.medium,
            fontSize: 20,
          ),
        ),
        leading: Padding(
          padding: const EdgeInsets.all(8.0),
          child: IconButton(
            icon: const Icon(Icons.menu, color: Color(0xFF1D1B1E)),
            onPressed: () {},
          ),
        ),
        actions: const [
          Padding(
            padding: EdgeInsets.only(right: 16.0),
            child: CircleAvatar(
              radius: 16,
              backgroundColor: Color(0xFFEADDFF),
              child: Text(
                'JD',
                style: TextStyle(
                  color: Color(0xFF21005D),
                  fontSize: 12,
                  fontWeight: FontWeight.bold,
                ),
              ),
            ),
          ),
        ],
      ),
      body: SafeArea(
        child: Padding(
          padding: const EdgeInsets.symmetric(horizontal: 16.0, vertical: 8.0),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.stretch,
            children: [
              // Folder Structure Card
              Container(
                decoration: BoxDecoration(
                  color: const Color(0xFFF3E9E5),
                  borderRadius: BorderRadius.circular(28),
                  border: Border.all(color: const Color(0xFFD8C2BC)),
                ),
                padding: const EdgeInsets.all(20),
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    const Text(
                      '1. FILE STRUCTURE',
                      style: TextStyle(
                        color: Color(0xFF6D5E5E),
                        fontWeight: FontWeight.bold,
                        fontSize: 12,
                        letterSpacing: 1.2,
                      ),
                    ),
                    const SizedBox(height: 12),
                    Container(
                      width: double.infinity,
                      decoration: BoxDecoration(
                        color: Colors.white.withOpacity(0.5),
                        borderRadius: BorderRadius.circular(16),
                        border: Border.all(color: const Color(0xFFD8C2BC)),
                      ),
                      padding: const EdgeInsets.all(16),
                      child: const Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Row(
                            children: [
                              Text('└─ ', style: TextStyle(color: Colors.black26, fontFamily: 'monospace')),
                              Text('lib/', style: TextStyle(color: Color(0xFF855353), fontWeight: FontWeight.bold, fontFamily: 'monospace')),
                            ],
                          ),
                          Padding(
                            padding: EdgeInsets.only(left: 24.0, top: 4.0),
                            child: Row(
                              children: [
                                Text('├─ ', style: TextStyle(color: Colors.black26, fontFamily: 'monospace')),
                                Text('main.dart', style: TextStyle(color: Color(0xFF3A3836), fontFamily: 'monospace')),
                                SizedBox(width: 8),
                                _StatusBadge(text: 'Core'),
                              ],
                            ),
                          ),
                          Padding(
                            padding: EdgeInsets.only(left: 24.0, top: 4.0),
                            child: Row(
                              children: [
                                Text('├─ ', style: TextStyle(color: Colors.black26, fontFamily: 'monospace')),
                                Text('constants.dart', style: TextStyle(color: Color(0xFF3A3836), fontFamily: 'monospace')),
                                SizedBox(width: 8),
                                _StatusBadge(text: 'Shared'),
                              ],
                            ),
                          ),
                          Padding(
                            padding: EdgeInsets.only(left: 24.0, top: 4.0),
                            child: Row(
                              children: [
                                Text('└─ ', style: TextStyle(color: Colors.black26, fontFamily: 'monospace')),
                                Text('models.dart', style: TextStyle(color: Color(0xFF3A3836), fontFamily: 'monospace')),
                                SizedBox(width: 8),
                                _StatusBadge(text: 'Data'),
                              ],
                            ),
                          ),
                        ],
                      ),
                    ),
                    const SizedBox(height: 12),
                    const Text(
                      'A flat hierarchy keeps navigation fast on mobile IDEs.',
                      style: TextStyle(
                        color: Color(0xFF6D5E5E),
                        fontSize: 13,
                        height: 1.3,
                      ),
                    ),
                  ],
                ),
              ),
              const SizedBox(height: 16),

              // Code Snippet Card
              Expanded(
                child: Container(
                  decoration: BoxDecoration(
                    color: const Color(0xFFFDF1E9),
                    borderRadius: BorderRadius.circular(28),
                    border: Border.all(color: const Color(0xFFE6D5CC)),
                  ),
                  padding: const EdgeInsets.all(20),
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.stretch,
                    children: [
                      const Row(
                        mainAxisAlignment: MainAxisAlignment.spaceBetween,
                        children: [
                          Text(
                            '2. INITIAL SHELL CODE',
                            style: TextStyle(
                              color: Color(0xFF6D5E5E),
                              fontWeight: FontWeight.bold,
                              fontSize: 12,
                              letterSpacing: 1.2,
                            ),
                          ),
                          Text(
                            'v1.0.0',
                            style: TextStyle(
                              color: Color(0xFF855353),
                              fontFamily: 'monospace',
                              fontSize: 11,
                            ),
                          ),
                        ],
                      ),
                      const SizedBox(height: 12),
                      Expanded(
                        child: SingleChildScrollView(
                          child: Column(
                            crossAxisAlignment: CrossAxisAlignment.stretch,
                            children: [
                              const Text(
                                'constants.dart',
                                style: TextStyle(
                                  color: Color(0xFF855353),
                                  fontFamily: 'monospace',
                                  fontSize: 11,
                                  fontWeight: FontWeight.bold,
                                ),
                              ),
                              const SizedBox(height: 4),
                              Container(
                                width: double.infinity,
                                decoration: BoxDecoration(
                                  color: const Color(0xFF1E1E1E),
                                  borderRadius: BorderRadius.circular(12),
                                ),
                                padding: const EdgeInsets.all(12),
                                child: const Text(
                                  "const kAppName = 'LiteShell';",
                                  style: TextStyle(
                                    color: Color(0xFFD4D4D4),
                                    fontFamily: 'monospace',
                                    fontSize: 12,
                                  ),
                                ),
                              ),
                              const SizedBox(height: 12),
                              const Text(
                                'models.dart',
                                style: TextStyle(
                                  color: Color(0xFF855353),
                                  fontFamily: 'monospace',
                                  fontSize: 11,
                                  fontWeight: FontWeight.bold,
                                ),
                              ),
                              const SizedBox(height: 4),
                              Container(
                                width: double.infinity,
                                decoration: BoxDecoration(
                                  color: const Color(0xFF1E1E1E),
                                  borderRadius: BorderRadius.circular(12),
                                ),
                                padding: const EdgeInsets.all(12),
                                child: const Text(
                                  "class AppUser {\n  final String id;\n  AppUser({required this.id});\n}",
                                  style: TextStyle(
                                    color: Color(0xFFD4D4D4),
                                    fontFamily: 'monospace',
                                    fontSize: 12,
                                    height: 1.4,
                                  ),
                                ),
                              ),
                            ],
                          ),
                        ),
                      ),
                    ],
                  ),
                ),
              ),
              const SizedBox(height: 16),

              // Bottom Button
              SizedBox(
                height: 56,
                child: ElevatedButton(
                  style: ElevatedButton.styleFrom(
                    backgroundColor: _isCompleted ? const Color(0xFF6D5E5E) : const Color(0xFF352E2B),
                    foregroundColor: Colors.white,
                    shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(28),
                    ),
                    elevation: 0,
                  ),
                  onPressed: () {
                    setState(() {
                      _isCompleted = !_isCompleted;
                    });
                    ScaffoldMessenger.of(context).showSnackBar(
                      SnackBar(
                        content: Text(
                          _isCompleted
                              ? 'Phase 1 Scaffolding Completed Successfully!'
                              : 'Reverted Phase 1 completion status.',
                        ),
                        duration: const Duration(seconds: 2),
                      ),
                    );
                  },
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      Text(
                        _isCompleted ? 'Phase 1 Completed' : 'Complete Phase 1',
                        style: const TextStyle(
                          fontSize: 16,
                          fontWeight: FontWeight.bold,
                        ),
                      ),
                      const SizedBox(width: 8),
                      Icon(
                        _isCompleted ? Icons.check : Icons.arrow_forward,
                        size: 20,
                      ),
                    ],
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}

class _StatusBadge extends StatelessWidget {
  final String text;

  const _StatusBadge({required this.text});

  @override
  Widget build(BuildContext context) {
    return Container(
      decoration: BoxDecoration(
        color: const Color(0xFFD8C2BC),
        borderRadius: BorderRadius.circular(4),
      ),
      padding: const EdgeInsets.symmetric(horizontal: 6, vertical: 2),
      child: Text(
        text,
        style: const TextStyle(
          color: Color(0xFF3A3836),
          fontSize: 10,
          fontWeight: FontWeight.bold,
        ),
      ),
    );
  }
}
